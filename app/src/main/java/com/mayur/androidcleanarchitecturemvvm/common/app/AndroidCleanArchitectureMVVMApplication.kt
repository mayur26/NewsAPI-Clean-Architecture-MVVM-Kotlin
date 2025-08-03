package com.mayur.androidcleanarchitecturemvvm.common.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AndroidCleanArchitectureMVVMApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }

}