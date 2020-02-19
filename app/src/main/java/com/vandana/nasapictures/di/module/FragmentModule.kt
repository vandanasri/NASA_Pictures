package com.vandana.nasapictures.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.vandana.nasapictures.data.db.DatabaseService
import com.vandana.nasapictures.ui.base.BaseFragment
import com.vandana.nasapictures.ui.fragment.NasaPictureFragmentViewModel
import com.vandana.nasapictures.util.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


@Module
class FragmentModule (private val fragment: BaseFragment<*>){

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(fragment.context)

    @Provides
    fun providesNasaPictureFragmentViewModel(
        compositeDisposable: CompositeDisposable,
        databaseService: DatabaseService
    ) : NasaPictureFragmentViewModel =
        ViewModelProviders.of(fragment, ViewModelProviderFactory(NasaPictureFragmentViewModel::class){
            NasaPictureFragmentViewModel(compositeDisposable, databaseService)
        }).get(NasaPictureFragmentViewModel::class.java)
}