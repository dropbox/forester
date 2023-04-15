package com.dropbox.forester.dagger

import com.squareup.javapoet.ClassName
import dagger.model.Binding
import dagger.model.BindingGraph
import dagger.model.BindingGraph.ComponentNode
import dagger.model.BindingKind
import dagger.spi.BindingGraphPlugin
import dagger.spi.DiagnosticReporter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.jetbrains.kotlin.konan.properties.suffix
import java.io.PrintWriter
import java.util.stream.Collectors
import javax.annotation.processing.Filer
import javax.lang.model.element.TypeElement
import javax.tools.StandardLocation
import com.dropbox.forester.dagger.Binding as DaggerBinding

@Suppress("UnstableApiUsage")
class ForesterGraphPlugin : BindingGraphPlugin {

    private lateinit var filer: Filer

    override fun initFiler(filer: Filer) {
        this.filer = filer
    }


    override fun visitGraph(bindingGraph: BindingGraph?, diagnosticReporter: DiagnosticReporter?) {
        if (bindingGraph == null) {
            return
        }

        val componentElement = bindingGraph.rootComponentNode()?.componentPath()?.currentComponent()
        val componentName = ClassName.get(componentElement)
        try {

            val moduleAndPkg = componentName.packageName()
            val relativeName = componentName.simpleNames().joinToString("_").suffix("_graph.json")


            val file = filer.createResource(
                StandardLocation.SOURCE_OUTPUT,
                moduleAndPkg,
                relativeName,
                componentElement
            )

            val graph = generateGraph(bindingGraph)

            val serializer = Json {
                prettyPrint = true
            }

            val json = serializer.encodeToString<Graph>(graph)


            val writer = PrintWriter(file.openWriter())
            writer.print(json)

        } catch (error: Throwable) {
            println(error)
        }
    }

    private fun generateGraph(bindingGraph: BindingGraph): Graph {
        val rootTypeElement = bindingGraph.rootComponentNode().componentPath().currentComponent()
        val rootName = ClassName.get(rootTypeElement).toString()
        return Graph(
            name = rootName,
            nodes = findNodes(bindingGraph)
        )
    }

    private fun findNodes(bindingGraph: BindingGraph): List<Node> {
        val network = bindingGraph.network()
        val stream = network.nodes().stream().map { node ->

            when (node) {
                is Binding -> {

                    val module = if (node.contributingModule().isPresent) {
                        node.contributingModule().get().toString()
                    } else {
                        null
                    }

                    val scope = if (node.scope().isPresent) {
                        node.scope().get().toString()
                    } else {
                        null
                    }

                    val dependencies = node.dependencies().stream().map { dependency ->
                        Dependency(
                            key = dependency.key().toString(),
                            kind = dependency.kind().toString(),
                            element = dependency.requestElement()?.toString()
                        )
                    }.collect(Collectors.toList())

                    val adjacentNodes = if (node.kind() == BindingKind.SUBCOMPONENT_CREATOR) {
                        network.adjacentNodes(node).stream().map { adjacentNode ->
                            when (adjacentNode) {
                                is Node -> adjacentNode.componentPath().currentComponent().toString()
                                is Binding -> adjacentNode.key().toString()
                                else -> null
                            }
                        }.collect(Collectors.toList()).filterNotNull()
                    } else {
                        null
                    }

                    DaggerBinding(
                        key = node.key().toString(),
                        kind = node.kind().toString(),
                        component = node.componentPath().currentComponent().toString(),
                        module = module,
                        scope = scope,
                        dependencies = dependencies,
                        adjacentNodes = adjacentNodes
                    )
                }

                is ComponentNode -> {
                    val component = if (node.componentPath().atRoot()) {
                        null
                    } else {
                        node.componentPath().rootComponent().toString()
                    }

                    val scopes = node
                        .scopes()
                        .stream()
                        .map { scope -> scope.scopeAnnotation().toString() }
                        .collect(Collectors.toList())
                        .filterNotNull()

                    val componentPath = node
                        .componentPath()
                        .components()
                        .stream()
                        .map(TypeElement::toString)
                        .collect(Collectors.toList())


                    val dependencies = node.entryPoints().stream().map { dependency ->
                        Dependency(
                            key = dependency.key().toString(),
                            kind = dependency.kind().toString(),
                            element = dependency.requestElement()?.toString()
                        )
                    }.collect(Collectors.toList()).filterNotNull()

                    Component(
                        key = node.componentPath().currentComponent().toString(),
                        component = component,
                        subcomponent = node.isSubcomponent,
                        componentPath = componentPath,
                        scopes = scopes,
                        dependencies = dependencies

                    )
                }

                else -> null
            }
        }

        return stream.collect(Collectors.toList()).filterNotNull()
    }


}


