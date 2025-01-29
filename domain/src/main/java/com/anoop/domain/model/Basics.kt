package com.anoop.domain.model

data class Basics(
    val label: String,
    val location: Location,
    val name: String,
    val phone: String,
    val profiles: List<Profile>,
    val summary: String
)