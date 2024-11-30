package com.example.onboardingtemplate.onboard

import android.content.Context

class OnboardingUtils(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("onboarding", Context.MODE_PRIVATE)

    fun isOnboardingCompleted(): Boolean {
        return sharedPreferences.getBoolean("completed", false)
    }

    fun setOnboardingCompleted() {
        sharedPreferences.edit().putBoolean("completed", true).apply()
    }

    fun setOnboardingStarted() {
        sharedPreferences.edit().putBoolean("completed", false).apply()
    }
//    fun isOnboardingCompleted(): Boolean {
//        return context.getSharedPreferences("onboarding", Context.MODE_PRIVATE)
//            .getBoolean("completed", false)
//    }
//
//    fun setOnboardingCompleted() {
//        context.getSharedPreferences("onboarding", Context.MODE_PRIVATE)
//            .edit()
//            .putBoolean("completed", true)
//            .apply()
//    }
//    fun setOnboardingStarted() {
//        context.getSharedPreferences("onboarding", Context.MODE_PRIVATE)
//            .edit()
//            .putBoolean("completed", false)
//            .apply()
//    }

}