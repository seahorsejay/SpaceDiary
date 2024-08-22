package com.example.galacticbook.domain

import com.example.galacticbook.BuildConfig
import com.example.galacticbook.di.CoreConfig

class CoreConfigImpl : CoreConfig {
    override fun getBaseUrl(): String = BuildConfig.BASE_URL
}