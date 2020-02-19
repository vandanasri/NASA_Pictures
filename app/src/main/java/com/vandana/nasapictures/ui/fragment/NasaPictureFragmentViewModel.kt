package com.vandana.nasapictures.ui.fragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.vandana.nasapictures.data.db.DatabaseService
import com.vandana.nasapictures.data.db.entity.NasaEntity
import com.vandana.nasapictures.data.model.NasaPictureData
import com.vandana.nasapictures.ui.base.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class NasaPictureFragmentViewModel(
    compositeDisposable: CompositeDisposable,
    databaseService: DatabaseService
) : BaseViewModel(compositeDisposable, databaseService) {

    val nasaDBDataList: MutableLiveData<List<NasaEntity>> = MutableLiveData()


    fun insetFileDataIntoDatabase(nasaPictureDataList: ArrayList<NasaPictureData>) {

        val nasaEntityList = arrayListOf<NasaEntity>()

        for ((index, nasaPictureData) in nasaPictureDataList.withIndex()) {
            nasaEntityList.add(
                NasaEntity(
                    index, nasaPictureData.title, nasaPictureData.url,
                    nasaPictureData.explanation, nasaPictureData.date
                )
            )
        }


        compositeDisposable.add(
            databaseService.getNasaDao().insert(nasaEntityList)
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        getAllNasaPictureData()
                    },
                    {
                        Log.d("TAG insetDatabase Error", it.toString())
                    }
                )
        )

    }

    fun getAllNasaPictureData() {
        compositeDisposable.add(
            databaseService.getNasaDao().getAllNasaData()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        nasaDBDataList.postValue(it)
                    },
                    {
                        Log.d("TAG readDatabase Error", it.toString())
                    }
                )
        )
    }


    fun getDataCount(): Int {
        var dataCount = 0
        compositeDisposable.add(
            databaseService.getNasaDao().getDataCount()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        dataCount = it
                    },
                    {
                        Log.d("TAG getDataCount Error", it.toString())
                    }
                )
        )
        return dataCount
    }

    override fun onCreate() {

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}