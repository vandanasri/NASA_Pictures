package com.vandana.nasapictures.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "nasa_table")
data class NasaEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NotNull
    var id: Integer,

    @ColumnInfo(name = "title")
    @NotNull
    var title: String,

    @ColumnInfo(name = "image_url")
    @NotNull
    var url: String,

    @ColumnInfo(name = "description")
    @NotNull
    var description :String,

    @ColumnInfo(name = "date")
    @NotNull
    var date :String

)