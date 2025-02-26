package com.example.onboardingtemplate

import android.app.Application
import com.example.onboardingtemplate.data.AppContainer
import com.example.onboardingtemplate.data.DefaultAppContainer


class KwanguKwakoApplication : Application() {
    lateinit var container : AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}