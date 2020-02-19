package com.vandana.nasapictures.ui.main


import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vandana.nasapictures.R
import com.vandana.nasapictures.data.Constants
import com.vandana.nasapictures.data.model.NasaPictureData
import com.vandana.nasapictures.di.component.ActivityComponent
import com.vandana.nasapictures.ui.base.BaseActivity
import com.vandana.nasapictures.ui.fragment.NasaPictureFragment
import com.vandana.nasapictures.util.common.AssetFileReader


class MainActivity : BaseActivity<MainViewModel>() {

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun injectDependencies(activityComponent: ActivityComponent) = activityComponent.inject(this)

    override fun setupView(savedInstanceState: Bundle?) {}

    override fun onResume() {
        super.onResume()

        addNasaPictureFragment()
    }

    private fun addNasaPictureFragment() {
        if (supportFragmentManager.findFragmentByTag(NasaPictureFragment.TAG) == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, NasaPictureFragment.newInstance(), NasaPictureFragment.TAG)
                .commitAllowingStateLoss()
        }
    }



}
