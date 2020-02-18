package com.vandana.nasapictures

import android.app.Application
import com.vandana.nasapictures.di.component.ApplicationComponent
import com.vandana.nasapictures.di.component.DaggerApplicationComponent
import com.vandana.nasapictures.di.module.ApplicationModule

class NasaPictureApplication : Application(){

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}