package com.vandana.nasapictures.di.component

import com.vandana.nasapictures.di.ActivityScope
import com.vandana.nasapictures.di.module.ActivityModule
import com.vandana.nasapictures.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton


@ActivityScope
@Component(dependencies = [ApplicationComponent::class],modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)
}