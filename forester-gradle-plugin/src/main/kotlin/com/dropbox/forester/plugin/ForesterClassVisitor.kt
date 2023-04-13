package com.dropbox.forester.plugin

import com.dropbox.forester.Forester
import com.dropbox.forester.Shape
import org.objectweb.asm.AnnotationVisitor
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.Opcodes

class ForesterClassVisitor(private val annotation: ForesterAnnotation) :
    ClassVisitor(Opcodes.ASM9) {
    var hasAnnotation = false
    private lateinit var nodeU: Forester.Node
    private lateinit var foresterAnnotationVisitor: ForesterAnnotationVisitor
    val edges: MutableSet<Forester.Edge> = mutableSetOf()
    private val nodes = mutableSetOf<String>()

    fun edges() {
        if (hasAnnotation) {
            when (annotation) {
                ForesterAnnotation.Directed -> {
                    nodes.filter { it != nodeU.qualifiedName?.simpleName() }.forEach { node ->
                        edges.add(
                            Forester.Edge(
                                u = nodeU,
                                v = Forester.Node(node, Shape.Class),
                                edgeType = Forester.Edge.Type.Directed
                            )
                        )
                    }
                }

                ForesterAnnotation.Undirected -> {
                    nodes.filter { it != nodeU.qualifiedName?.simpleName() }.forEach {
                        edges.add(
                            Forester.Edge(
                                u = nodeU,
                                v = Forester.Node(it, Shape.Class),
                                edgeType = Forester.Edge.Type.Undirected
                            )
                        )
                    }
                }

                else -> {}
            }
        }
    }


    override fun visit(
        version: Int,
        access: Int,
        name: String?,
        signature: String?,
        superName: String?,
        interfaces: Array<out String>?
    ) {
        nodeU = Forester.Node(name, shape = Shape.Class)
    }

    override fun visitAnnotation(
        descriptor: String?,
        visible: Boolean
    ): AnnotationVisitor {
        val eligible = listOf(ForesterAnnotation.Directed, ForesterAnnotation.Undirected)
        foresterAnnotationVisitor = ForesterAnnotationVisitor(
            api,
            nodeU.qualifiedName?.simpleName(),
            eligible.contains(annotation)
        ) {
            nodes.add(it)
        }

        if (descriptor?.contains(annotation.descriptor) == true) {
            hasAnnotation = true
        }

        foresterAnnotationVisitor.visitArray("nodes")

        return foresterAnnotationVisitor
    }


    private class FallbackVisitor : AnnotationVisitor(Opcodes.ASM9) {
        var hasAnnotation = false
    }
}