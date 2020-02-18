package com.vandana.nasapictures.di.module

import android.app.Application
import android.content.Context
import com.vandana.nasapictures.NasaPictureApplication
import com.vandana.nasapictures.di.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ApplicationModule(private  val  application: NasaPictureApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = application


}