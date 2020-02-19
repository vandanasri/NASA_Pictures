package com.vandana.nasapictures.di.module

import android.app.Activity
import android.content.Context
import com.vandana.nasapictures.di.ActivityContext
import dagger.Module
import dagger.Provides


@Module
class ActivityModule(private val activity: Activity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = activity
}