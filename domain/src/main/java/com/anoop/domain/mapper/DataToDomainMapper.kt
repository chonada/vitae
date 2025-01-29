package com.anoop.domain.mapper


import com.anoop.data.model.ResumeData
import com.anoop.domain.model.Basics
import com.anoop.domain.model.Education
import com.anoop.domain.model.Language
import com.anoop.domain.model.Location
import com.anoop.domain.model.Profile
import com.anoop.domain.model.Reference
import com.anoop.domain.model.Resume
import com.anoop.domain.model.Skill
import com.anoop.domain.model.Work
import com.anoop.data.model.Basics as BasicsData
import com.anoop.data.model.Education as EducationData
import com.anoop.data.model.Language as LanguageData
import com.anoop.data.model.Location as LocationData
import com.anoop.data.model.Profile as ProfileData
import com.anoop.data.model.Reference as ReferenceData
import com.anoop.data.model.Skill as SkillData
import com.anoop.data.model.Work as WorkData

object DataToDomainMapper {

    private fun mapBasicsDataToDomain(basicsData: BasicsData): Basics {
        return Basics(
            label = checkNotNull(basicsData.label),
            location = mapLocationDataToDomain(checkNotNull(basicsData.location)),
            name = checkNotNull(basicsData.name),
            phone = checkNotNull(basicsData.phone),
            profiles = checkNotNull(basicsData.profiles).map { mapProfileDataToDomain(it) },
            summary = checkNotNull(basicsData.summary),
            email = checkNotNull(basicsData.email)
        )
    }

    private fun mapLocationDataToDomain(locationData: LocationData): Location {
        return Location(
            address = checkNotNull(locationData.address),
            city = checkNotNull(locationData.city),
            countryCode = checkNotNull(locationData.countryCode),
            postalCode = checkNotNull(locationData.postalCode),
            state = checkNotNull(locationData.state)
        )
    }

    private fun mapProfileDataToDomain(profileData: ProfileData): Profile {
        return Profile(
            network = checkNotNull(profileData.network),
            url = checkNotNull(profileData.url),
            username = checkNotNull(profileData.username)
        )
    }

    private fun mapWorkDataToDomain(workData: WorkData): Work {
        return Work(
            company = checkNotNull(workData.company),
            endDate = checkNotNull(workData.endDate),
            position = checkNotNull(workData.position),
            startDate = checkNotNull(workData.startDate),
            summary = checkNotNull(workData.summary)
        )
    }

    private fun mapEducationDataToDomain(educationData: EducationData): Education {
        return Education(
            area = checkNotNull(educationData.area),
            endDate = checkNotNull(educationData.endDate),
            institution = checkNotNull(educationData.institution),
            startDate = checkNotNull(educationData.startDate),
            studyType = checkNotNull(educationData.studyType),
        )
    }

    private fun mapLanguageDataToDomain(languageData: LanguageData): Language {
        return Language(
            language = checkNotNull(languageData.language),
            fluency = checkNotNull(languageData.fluency)
        )
    }

    private fun mapReferenceDataToDomain(referenceData: ReferenceData): Reference {
        return Reference(
            name = checkNotNull(referenceData.name),
            reference = checkNotNull(referenceData.reference)
        )
    }

    private fun mapSkillDataToDomain(skillData: SkillData): Skill {
        return Skill(
            name = checkNotNull(skillData.name)
        )
    }

    fun mapResumeDataToDomain(resumeData: ResumeData): Resume = resumeData.run {
        Resume(
            basics = mapBasicsDataToDomain(checkNotNull(basics)),
            education = education.map { mapEducationDataToDomain(it) },
            languages = languages.map { mapLanguageDataToDomain(it) },
            references = references.map { mapReferenceDataToDomain(it) },
            skills = skills.map { mapSkillDataToDomain(it) },
            work = work.map { mapWorkDataToDomain(it) }
        )
    }
}