package com.vandana.nasapictures

import android.app.Application
import com.vandana.nasapictures.ui.component.ApplicationComponent
import com.vandana.nasapictures.ui.component.DaggerApplicationComponent
import com.vandana.nasapictures.ui.module.ApplicationModule

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