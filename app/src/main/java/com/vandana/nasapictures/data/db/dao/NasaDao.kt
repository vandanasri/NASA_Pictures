package com.vandana.nasapictures.data.db.dao

import androidx.room.*
import com.vandana.nasapictures.data.db.entity.NasaEntity
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface NasaDao {

    @Query("SELECT * FROM nasa_table")
    fun getAllNasaData() : Flowable<List<NasaEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: List<NasaEntity> ) : Completable

    @Delete
    fun delete(entity: NasaEntity)


    @Query("SELECT COUNT(title) FROM nasa_table")
    fun getDataCount() : Flowable<Int>

}