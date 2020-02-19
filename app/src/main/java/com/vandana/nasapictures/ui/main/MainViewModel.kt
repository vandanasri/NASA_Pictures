package com.vandana.nasapictures.ui.main

import com.vandana.nasapictures.data.db.DatabaseService
import com.vandana.nasapictures.di.ActivityScope
import com.vandana.nasapictures.ui.base.BaseViewModel
import io.reactivex.disposables.CompositeDisposable


@ActivityScope
class MainViewModel(
    compositeDisposable: CompositeDisposable,
    databaseService: DatabaseService
) : BaseViewModel(compositeDisposable, databaseService){

    override fun onCreate() {

    }
}