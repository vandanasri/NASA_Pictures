package com.vandana.nasapictures.ui.main


import android.os.Bundle
import com.vandana.nasapictures.R
import com.vandana.nasapictures.di.component.ActivityComponent
import com.vandana.nasapictures.ui.base.BaseActivity


class MainActivity : BaseActivity<MainViewModel>() {

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun injectDependencies(activityComponent: ActivityComponent) = activityComponent.inject(this)

    override fun setupView(savedInstanceState: Bundle?) {}

    override fun onResume() {
        super.onResume()

    }



}
