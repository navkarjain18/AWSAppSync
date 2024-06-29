package com.appsyncsample

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AwsAppSync : Application() {

    companion object {
        lateinit var instance: AwsAppSync private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}