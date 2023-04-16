package com.dropbox.forester.android.api.entity

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    val name: String,
    val email: String,
    val avatarUrl: String
)