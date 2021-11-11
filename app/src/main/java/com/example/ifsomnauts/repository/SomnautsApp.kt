package com.example.ifsomnauts.repository

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp()
class SomnautsApp: Application() {
    private var mInstance: SomnautsApp? = null
    override fun onCreate() {
        super.onCreate()
        mInstance = this

    }

    @Synchronized
    fun getInstance(): SomnautsApp? {
        return mInstance
    }

    fun getAppContext(): Context? {
        return mInstance?.applicationContext
    }
}