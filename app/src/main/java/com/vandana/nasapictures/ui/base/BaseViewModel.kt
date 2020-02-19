package com.vandana.nasapictures.ui.base


import androidx.lifecycle.ViewModel
import com.vandana.nasapictures.data.db.DatabaseService
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(
    protected val compositeDisposable: CompositeDisposable,
    protected val databaseService: DatabaseService

) : ViewModel() {




    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    abstract fun onCreate()
}