package com.vandana.nasapictures.di.component

import com.vandana.nasapictures.di.FragmentScope
import com.vandana.nasapictures.di.module.FragmentModule
import com.vandana.nasapictures.ui.fragment.NasaPictureFragment
import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(fragment: NasaPictureFragment)

}