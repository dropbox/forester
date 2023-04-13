@file:Suppress("UNCHECKED_CAST")

package com.dropbox.forester.plugin

import org.objectweb.asm.AnnotationVisitor

class ForesterAnnotationVisitor(
    api: Int,
    private val simpleName: String?,
    private val collectEdges: Boolean = false,
    val addNode: (className: String) -> Unit
) :
    AnnotationVisitor(api) {
    val nodes = mutableSetOf<String>()

    override fun visitArray(name: String?): AnnotationVisitor {

        return this.apply { nodes.addAll(this.nodes) }
    }

    override fun visit(name: String?, value: Any?) {
        if (collectEdges && value.toString().startsWith("L")) {
            val className = value.toString().removePrefix("L").replace(";", "").replace("/", ".")
            if (className != simpleName) {
                nodes.add(className)
                addNode(className)
            }
        }
        super.visit(name, value)
    }
}