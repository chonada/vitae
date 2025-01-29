package com.anoop.data.datasource

import com.anoop.data.model.ResumeData

interface ResumeDataSource {
    suspend fun getResume(): ResumeData
}