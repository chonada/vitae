package com.anoop.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ResumeData(
    val basics: Basics?,
    val name: String?,
    val summary: String?,
    val label: String,
    val location: Location?,
    val phone: String?,
    val profiles: List<Profile>,
    val work: List<Work>,
    val education: List<Education>,
    val languages: List<Language>,
    val references: List<Reference>,
    val skills: List<Skill>,
)