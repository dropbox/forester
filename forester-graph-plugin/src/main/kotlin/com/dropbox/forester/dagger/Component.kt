package com.dropbox.forester.dagger

import kotlinx.serialization.Serializable

@Serializable
data class Component(
    val key: String,
    val component: String?,
    val subcomponent: Boolean,
    val componentPath: List<String>,
    val scopes: List<String>?,
    val dependencies: List<Dependency>
) : Node()