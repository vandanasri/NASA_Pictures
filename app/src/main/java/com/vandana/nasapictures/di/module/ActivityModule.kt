package com.vandana.nasapictures.di.module

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.vandana.nasapictures.data.db.DatabaseService
import com.vandana.nasapictures.di.ActivityContext
import com.vandana.nasapictures.ui.base.BaseActivity
import com.vandana.nasapictures.ui.main.MainViewModel
import com.vandana.nasapictures.util.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = activity

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)


    @Provides
    fun provideMainViewModel(
        compositeDisposable: CompositeDisposable,
        databaseService: DatabaseService
    ): MainViewModel =
        ViewModelProviders.of(activity, ViewModelProviderFactory(MainViewModel::class) {
            MainViewModel(compositeDisposable, databaseService)
        }).get(MainViewModel::class.java)
}