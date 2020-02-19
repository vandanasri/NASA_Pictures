package com.vandana.nasapictures.ui.fragment


import com.vandana.nasapictures.data.db.DatabaseService
import com.vandana.nasapictures.ui.base.BaseViewModel
import io.reactivex.disposables.CompositeDisposable


class NasaPictureFragmentViewModel (
    compositeDisposable: CompositeDisposable,
    databaseService: DatabaseService
) : BaseViewModel(compositeDisposable, databaseService) {








    override fun onCreate() {

    }
}