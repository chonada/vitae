package com.anoop.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    val network: String?,
    val url: String?,
    val username: String?
)