package com.anoop.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Work(
    val company: String?,
    val endDate: String?,
    val position: String?,
    val startDate: String?,
    val summary: String?
)