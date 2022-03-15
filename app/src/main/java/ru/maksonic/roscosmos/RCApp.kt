package ru.maksonic.roscosmos

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * @Author: maksonic on 12.03.2022
 */
@HiltAndroidApp
class RCApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}