package com.dropbox.forester.plugin

enum class ForesterAnnotation(val descriptor: String) {
    Node("Lcom/dropbox/forester/Node;"),
    Forest("Lcom/dropbox/forester/Forest;"),
    Graph("Lcom/dropbox/forester/Graph;"),
    Directed("Lcom/dropbox/forester/Directed;"),
    Undirected("Lcom/dropbox/forester/Undirected;")
}