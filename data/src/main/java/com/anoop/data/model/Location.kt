package com.anoop.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val countryCode: String?,
    val postalCode: String?,
    val address: String?,
    val city: String?,
    val state: String?,
)