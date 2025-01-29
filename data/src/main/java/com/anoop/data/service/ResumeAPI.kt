package com.anoop.data.service

import com.anoop.data.model.ResumeData
import retrofit2.http.GET

interface ResumeAPI {
    @GET("resume.json")
    suspend fun getResume() : ResumeData
}