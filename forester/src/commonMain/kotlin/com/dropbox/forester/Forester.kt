package com.dropbox.forester

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

sealed class Forester {
    @Serializable
    data class Edge(
        val u: Node,
        val v: Node,
        val edgeType: Type
    ) {

        @Serializable
        enum class Type(val value: String) {
            Directed("Directed"),
            Undirected("Undirected")
        }
    }

    @Serializable
    data class Node(
        val qualifiedName: String? = null,
        val shape: Shape = Shape.Rectangle,
        val loadable: Boolean = true,
    )

    @Serializable
    data class Graph(
        val edges: MutableSet<Edge> = mutableSetOf()
    ) {
        fun undirected(head: Node, tail: Node): Graph {
            edges.add(Edge(head, tail, Edge.Type.Undirected))
            return this
        }


        fun directed(head: Node, tail: Node): Graph {
            edges.add(Edge(head, tail, Edge.Type.Directed))
            return this
        }

        fun directed(head: KClass<*>, tail: KClass<*>): Graph {
            edges.add(
                Edge(
                    Node(head.qualifiedName),
                    Node(tail.qualifiedName),
                    Edge.Type.Directed
                )
            )
            return this
        }

        fun directed(head: KClass<*>, tail: Node): Graph {
            edges.add(Edge(Node(head.qualifiedName), tail, Edge.Type.Directed))
            return this
        }

        fun directed(head: Node, tail: KClass<*>): Graph {
            edges.add(Edge(head, Node(tail.qualifiedName), Edge.Type.Directed))
            return this
        }
    }


}


fun graph(graph: Forester.Graph.() -> Unit): Forester.Graph = Forester.Graph().apply {
    graph()
}

fun node(qualifiedName: String? = null, shape: Shape = Shape.Rectangle, loadable: Boolean = true) =
    Forester.Node(qualifiedName, shape, loadable)

fun node(path: String? = null, shape: Shape = Shape.Rectangle): Forester.Node {
    return Forester.Node(path, shape, loadable = false)
}

fun node(clazz: KClass<*>, shape: Shape = Shape.Rectangle): Forester.Node {
    return Forester.Node(clazz.qualifiedName!!, shape, loadable = true)
}