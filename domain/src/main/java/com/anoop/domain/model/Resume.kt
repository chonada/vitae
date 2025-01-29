package com.anoop.domain.model

data class Resume(
    val basics: Basics,
    val education: List<Education>,
    val languages: List<Language>,
    val references: List<Reference>,
    val skills: List<Skill>,
    val work: List<Work>
)