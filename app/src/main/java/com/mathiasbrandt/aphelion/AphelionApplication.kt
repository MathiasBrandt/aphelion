package com.mathiasbrandt.aphelion

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import com.mathiasbrandt.aphelion.di.AppComponent
import com.mathiasbrandt.aphelion.di.AppModule
import com.mathiasbrandt.aphelion.di.DaggerAppComponent

class AphelionApplication : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)

        AndroidThreeTen.init(this)
    }

    fun initDagger(app: AphelionApplication): AppComponent =
            DaggerAppComponent
                    .builder()
                    .appModule(AppModule(app))
                    .build()
}