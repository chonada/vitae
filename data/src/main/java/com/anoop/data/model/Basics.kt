package com.anoop.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Basics(
    val label: String?,
    val location: Location?,
    val name: String?,
    val phone: String?,
    val email: String?,
    val profiles: List<Profile>,
    val summary: String?
)