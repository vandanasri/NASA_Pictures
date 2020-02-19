package com.vandana.nasapictures.ui.fragment

import android.content.Context
import android.view.View
import androidx.lifecycle.Observer
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.vandana.nasapictures.R
import com.vandana.nasapictures.data.Constants
import com.vandana.nasapictures.data.model.NasaPictureData
import com.vandana.nasapictures.di.component.FragmentComponent
import com.vandana.nasapictures.ui.base.BaseFragment
import com.vandana.nasapictures.util.common.AssetFileReader
import com.vandana.nasapictures.util.common.AutoFitGridLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*
import java.lang.reflect.Type


class NasaPictureFragment : BaseFragment<NasaPictureFragmentViewModel>() {

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

    override fun injectDependencies(fragmentComponent: FragmentComponent) =
        fragmentComponent.inject(this)

    override fun setupView(view: View) {

        getDataFromJsonFile(mContext)

        viewModel.nasaDBDataList.observe(this, Observer {
            val adapter = NasaPictureViewAdapter(it)
            val manager = AutoFitGridLayoutManager(mContext, 500)
            rv_repository.layoutManager = manager
            rv_repository.adapter = adapter
        })

    }


    private fun getDataFromJsonFile(context: Context) {
        if (viewModel.getDataCount() == 0) {

            val data = AssetFileReader.readJSONFromAsset(context, Constants.FILE_NAME)

            val type = object : TypeToken<ArrayList<NasaPictureData>>() {}.type
            val list: ArrayList<NasaPictureData> = parseArray(json = data, typeToken = type)


            if (list.size > 0)
                viewModel.insetFileDataIntoDatabase(list)


        } else {
            viewModel.getAllNasaPictureData()
        }
    }

    private inline fun <reified T> parseArray(json: String?, typeToken: Type): T {
        val gson = GsonBuilder().create()
        return gson.fromJson<T>(json, typeToken)
    }


}