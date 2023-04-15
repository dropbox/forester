package com.dropbox.forester.dagger

import kotlinx.serialization.Serializable

@Serializable
data class Binding(
    val key: String,
    val kind: String,
    val component: String,
    val module: String?,
    val scope: String?,
    val dependencies: List<Dependency>,
    val adjacentNodes: List<String>?
) : Node()