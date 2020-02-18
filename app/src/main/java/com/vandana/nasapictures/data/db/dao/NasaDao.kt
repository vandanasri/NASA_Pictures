package com.vandana.nasapictures.data.db.dao

import androidx.room.*
import com.vandana.nasapictures.data.db.entity.NasaEntity
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface NasaDao {

    @Query("SELECT * FROM nasa_table")
    fun getAllNasaData() : Flowable<NasaEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: NasaEntity) : Completable

    @Delete
    fun delete(entity: NasaEntity)


}