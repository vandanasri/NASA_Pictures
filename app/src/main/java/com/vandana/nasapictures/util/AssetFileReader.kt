package com.vandana.nasapictures.util

import android.content.Context
import java.io.InputStream


class AssetFileReader(context: Context, fileName: String) {

    private val mContext:Context = context
    private val fName :String = fileName


    //function to read json file from Asset folder

        fun readJSONFromAsset(): String? {
            var json: String? = null
            try {
                val  inputStream:InputStream = mContext.assets.open(fName)
                json = inputStream.bufferedReader().use{it.readText()}
            } catch (ex: Exception) {
                ex.printStackTrace()
                return null
            }
            return json
        }



}