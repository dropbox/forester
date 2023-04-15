package com.dropbox.forester.dagger

import kotlinx.serialization.Serializable

@Serializable
data class Graph(
    val name: String,
    val nodes: List<Node>
)