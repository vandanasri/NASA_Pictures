package com.vandana.nasapictures.ui.detail

import android.os.Bundle
import com.bumptech.glide.Glide
import com.vandana.nasapictures.R
import com.vandana.nasapictures.di.component.ActivityComponent
import com.vandana.nasapictures.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity<DetailViewModel>() {

    override fun provideLayoutId(): Int = R.layout.activity_detail

    override fun injectDependencies(activityComponent: ActivityComponent) = activityComponent.inject(this)

    override fun setupView(savedInstanceState: Bundle?) {


        Glide.with(this).load(intent.getStringExtra("url")).into(ivImage)
        tvTitle.text= "Title: ${intent.getStringExtra("title")}"
        tvDescription.text= "Description: ${intent.getStringExtra("desc")}"
        tvDate.text= "Date: ${intent.getStringExtra("date")}"
    }
}