package com.vandana.nasapictures.ui.fragment



import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vandana.nasapictures.data.Constants
import com.vandana.nasapictures.data.db.DatabaseService
import com.vandana.nasapictures.data.db.entity.NasaEntity
import com.vandana.nasapictures.data.model.NasaPictureData
import com.vandana.nasapictures.ui.base.BaseViewModel
import com.vandana.nasapictures.util.common.AssetFileReader
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class NasaPictureFragmentViewModel (
    compositeDisposable: CompositeDisposable,
    databaseService: DatabaseService
) : BaseViewModel(compositeDisposable, databaseService) {




     fun getDataFromJsonFile(context: Context)
    {
        if(getDataCount()==0) {

            val data = AssetFileReader.readJSONFromAsset(context, Constants.FILE_NAME)

            val type = TypeToken.get(ArrayList<NasaPictureData>().javaClass).type
            val list: ArrayList<NasaPictureData> = Gson().fromJson(data, type)
        if(list.size >0)
            insetFileDataIntoDatabase(list)

        }else{
            getAllNasaPictureData()
        }
    }



  private fun insetFileDataIntoDatabase(nasaPictureDataList : ArrayList<NasaPictureData>){

      val nasaEntityList: ArrayList<NasaEntity> = ArrayList()

      for(nasaPictureData in nasaPictureDataList){
          nasaEntityList.add(NasaEntity(1,nasaPictureData.title,nasaPictureData.url,
              nasaPictureData.explanation,nasaPictureData.date))
      }

     compositeDisposable.add(
         databaseService.getNasaDao().insert(nasaEntityList)
             .subscribe(
                 {
                    getAllNasaPictureData()
                 },
                 {
                     Log.d("TAG", it.toString())
                 }
             )
     )

 }



     private fun getAllNasaPictureData() {
        compositeDisposable.add(
            databaseService.getNasaDao().getAllNasaData()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {

                    },
                    {

                    }
                )
        )
    }





     private fun getDataCount() : Int {
        var dataCount = 0
        compositeDisposable.add(
            databaseService.getNasaDao().getDataCount()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        dataCount = it
                    },
                    {
                    }
                )
        )
        return dataCount
    }

    override fun onCreate() {

    }
}