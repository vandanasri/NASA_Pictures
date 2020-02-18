package com.vandana.nasapictures.di.component

import android.app.Application
import android.content.Context
import com.vandana.nasapictures.NasaPictureApplication
import com.vandana.nasapictures.di.ApplicationContext
import com.vandana.nasapictures.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: NasaPictureApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getApplication(): Application
}