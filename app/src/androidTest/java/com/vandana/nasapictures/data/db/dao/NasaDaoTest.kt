package com.vandana.nasapictures.data.db.dao

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.vandana.nasapictures.data.db.DatabaseService
import com.vandana.nasapictures.data.db.entity.NasaEntity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.io.IOException

class NasaDaoTest {

    private lateinit var nasaDao: NasaDao

    private lateinit var mDatabase: DatabaseService

    private val nasaEntityList: ArrayList<NasaEntity> = ArrayList()


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        mDatabase = Room.inMemoryDatabaseBuilder(
            context, DatabaseService::class.java
        )
            .allowMainThreadQueries()
            .build()

        nasaDao = mDatabase.getNasaDao()

    }


    @Test
    fun insertNasaData() {
        nasaEntityList.add(NasaEntity(1, "title1", "url1", "description1", "1/2/20"))

        mDatabase.clearAllTables()
        nasaDao.insert(nasaEntityList).blockingAwait()

        nasaDao.getAllNasaData()
            .test()
            .assertValueCount(1)


    }


    @After
    @Throws(IOException::class)
    fun closeDb() {
        mDatabase.close()
    }
}