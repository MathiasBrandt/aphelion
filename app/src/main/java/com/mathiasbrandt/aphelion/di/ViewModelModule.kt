package com.mathiasbrandt.aphelion.di

import com.mathiasbrandt.aphelion.data.DataManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {
    @Provides
    @Singleton
    fun provideDataManager(): DataManager = DataManager()
}