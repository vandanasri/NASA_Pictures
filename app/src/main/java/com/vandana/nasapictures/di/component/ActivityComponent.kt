package com.vandana.nasapictures.di.component

import com.vandana.nasapictures.di.module.ActivityModule
import com.vandana.nasapictures.ui.main.MainActivity
import dagger.Component



@Component(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)
}