package com.dropbox.forester.android.api

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    val name: String,
    val avatarUrl: String,
)