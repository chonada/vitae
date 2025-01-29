package com.anoop.data.service

import com.anoop.common.buildconfig.BuildConfigFieldsProvider
import com.anoop.data.datasource.ResumeDataSource
import com.anoop.data.model.ResumeData
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Inject
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://www.anoopc.com/"

@Singleton
class ResumeService @Inject constructor(
    networkJson: Json,
    okhttpCallFactory: dagger.Lazy<Call.Factory>
): ResumeDataSource {
    private val api: ResumeAPI = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .callFactory{ okhttpCallFactory.get().newCall(it) }
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType()),
        )
        .build()
        .create(ResumeAPI::class.java)

    override suspend fun getResume(): ResumeData = api.getResume()
}