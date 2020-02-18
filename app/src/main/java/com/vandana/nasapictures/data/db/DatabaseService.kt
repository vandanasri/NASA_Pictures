package com.vandana.nasapictures.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vandana.nasapictures.data.db.dao.NasaDao
import com.vandana.nasapictures.data.db.entity.NasaEntity
import javax.inject.Singleton


@Singleton
@Database(
    entities = [NasaEntity::class], exportSchema = false, version = 1
)
abstract class DatabaseService : RoomDatabase() {

    abstract fun getNasaDao(): NasaDao
}