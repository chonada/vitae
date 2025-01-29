package com.anoop.vitae.ui.screens

import com.anoop.domain.model.Basics
import com.anoop.domain.model.Location
import com.anoop.domain.model.Profile
import com.anoop.domain.model.Resume
import com.anoop.domain.model.Education
import com.anoop.domain.model.Language
import com.anoop.domain.model.Reference
import com.anoop.domain.model.Skill
import com.anoop.domain.model.Work

object DummyPreviewData {
    val dummyResume = Resume(
        basics = Basics(
            label = "Software Engineer",
            location = Location(
                address = "123 Main St",
                city = "Anytown",
                countryCode = "US",
                postalCode = "12345",
                state = "NSW"
            ),
            name = "John Doe",
            phone = "555-123-4567",
            profiles = listOf(
                Profile(
                    network = "LinkedIn",
                    url = "linkedin.com/in/johndoe",
                    username = "johndoe"
                ),
                Profile(
                    network = "GitHub",
                    url = "github.com/johndoe",
                    username = "johndoe"
                )
            ),
            summary = "Experienced software engineer with a passion for building high-quality applications.",
            email = "john@does.com"
        ),
        education = listOf(
            Education(
                area = "Computer Science",
                endDate = "2020-05-01",
                institution = "University X",
                startDate = "2016-09-01",
                studyType = "Bachelor"
            ),
            Education(
                area = "Data Science",
                endDate = "2022-05-01",
                institution = "University Y",
                startDate = "2020-09-01",
                studyType = "Master"
            )
        ),
        languages = listOf(
            Language(
                language = "English",
                fluency = "Native"
            ),
            Language(
                language = "Spanish",
                fluency = "Conversational"
            )
        ),
        references = listOf(
            Reference(
                name = "Jane Smith",
                reference = "Professor at University X"
            ),
            Reference(
                name = "Peter Jones",
                reference = "Manager at Company Z"
            )
        ),
        skills = listOf(
            Skill(
                name = "Android Development"
            ),
            Skill(
                name = "Machine Learning"
            )
        ),
        work = listOf(
            Work(
                company = "Company Z",
                endDate = "2023-12-31",
                position = "Senior Software Engineer",
                startDate = "2021-01-01",
                summary = "Developed and maintained Android applications..."
            ),
            Work(
                company = "Company Y",
                endDate = "2020-12-31",
                position = "Software Engineer",
                startDate = "2019-01-01",
                summary = "Worked on various software projects..."
            )
        )
    )

}