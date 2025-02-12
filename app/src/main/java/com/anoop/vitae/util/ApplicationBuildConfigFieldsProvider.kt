package com.anoop.vitae.util

import com.anoop.common.buildconfig.BuildConfigFields
import com.anoop.common.buildconfig.BuildConfigFieldsProvider
import com.anoop.vitae.BuildConfig
import javax.inject.Inject

class ApplicationBuildConfigFieldsProvider @Inject constructor() : BuildConfigFieldsProvider {

    override fun get(): BuildConfigFields = BuildConfigFields(
        buildType = BuildConfig.BUILD_TYPE,
        versionCode = BuildConfig.VERSION_CODE,
        versionName = BuildConfig.VERSION_NAME,
    )
}