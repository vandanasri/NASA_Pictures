package com.vandana.nasapictures.ui.fragment

import android.content.Context
import android.view.View
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vandana.nasapictures.R
import com.vandana.nasapictures.data.Constants
import com.vandana.nasapictures.data.model.NasaPictureData
import com.vandana.nasapictures.di.component.FragmentComponent
import com.vandana.nasapictures.ui.base.BaseFragment
import com.vandana.nasapictures.util.common.AssetFileReader


class NasaPictureFragment : BaseFragment<NasaPictureFragmentViewModel>(){

    private lateinit var mContext: Context

    companion object {
        val TAG = NasaPictureFragment::class.java.simpleName
        fun newInstance(): NasaPictureFragment {
            return NasaPictureFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context

    }

    override fun provideLayoutId(): Int = R.layout.fragment_main

    override fun injectDependencies(fragmentComponent: FragmentComponent) = fragmentComponent.inject(this)

    override fun setupView(view: View) {

       viewModel.getDataFromJsonFile(mContext)
    }



}