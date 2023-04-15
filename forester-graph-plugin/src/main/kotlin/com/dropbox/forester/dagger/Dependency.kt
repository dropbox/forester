package com.dropbox.forester.dagger

import kotlinx.serialization.Serializable

@Serializable
data class Dependency(
    val key: String,
    val kind: String,
    val element: String?
)