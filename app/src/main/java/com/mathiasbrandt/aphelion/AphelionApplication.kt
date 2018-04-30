package com.mathiasbrandt.aphelion

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class AphelionApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}