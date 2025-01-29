package com.anoop.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Education(
    val area: String?,
    val endDate: String?,
    val institution: String?,
    val startDate: String?,
    val studyType: String?
)