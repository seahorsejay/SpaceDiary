package com.example.galacticbook

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class GalacticApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}