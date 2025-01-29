package com.anoop.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Reference(
    val name: String?,
    val reference: String?
)