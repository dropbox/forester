package com.dropbox.forester.android.api.entity

import kotlinx.serialization.Serializable

@Serializable
data class Machine(
    val id: Int,
    val item: NamedApiResource,
    val move: NamedApiResource,
    val versionGroup: NamedApiResource
)