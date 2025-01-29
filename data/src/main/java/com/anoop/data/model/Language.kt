package com.anoop.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Language(
    val fluency: String?,
    val language: String?
)