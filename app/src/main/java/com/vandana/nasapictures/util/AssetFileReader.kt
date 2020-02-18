package com.vandana.nasapictures.util

import android.content.Context
import java.io.InputStream


object AssetFileReader {

    //function to read json file from Asset folder

        fun readJSONFromAsset(context: Context,fileName: String): String? {
            var json: String? = null
            try {
                val  inputStream:InputStream = context.assets.open(fileName)
                json = inputStream.bufferedReader().use{it.readText()}
            } catch (ex: Exception) {
                ex.printStackTrace()
                return null
            }
            return json
        }



}