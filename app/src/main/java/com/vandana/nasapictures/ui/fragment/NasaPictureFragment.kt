package com.vandana.nasapictures.ui.fragment

import android.content.Context
import android.view.View
import com.vandana.nasapictures.R
import com.vandana.nasapictures.di.component.FragmentComponent
import com.vandana.nasapictures.ui.base.BaseFragment


class NasaPictureFragment : BaseFragment<NasaPictureFragmentViewModel>(){

    private lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun provideLayoutId(): Int = R.layout.fragment_main

    override fun injectDependencies(fragmentComponent: FragmentComponent) = fragmentComponent.inject(this)

    override fun setupView(view: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}