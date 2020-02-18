package com.vandana.nasapictures.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NasaPictureData(

    @SerializedName("copyright")
    @Expose
    var copyright:String,

    @SerializedName("date")
    @Expose
    var date:String,

    @SerializedName("explanation")
    @Expose
    var explanation:String,

    @SerializedName("hdurl")
    @Expose
    var hdurl: String,

    @SerializedName("media_type")
    @Expose
    var mediaType:String,

    @SerializedName("service_version")
    @Expose
    var serviceVersion :String,

    @SerializedName("title")
    @Expose
    var title:String,

    @SerializedName("url")
    @Expose
    var url:String
)