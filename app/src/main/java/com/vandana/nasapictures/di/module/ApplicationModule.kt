package com.vandana.nasapictures.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.vandana.nasapictures.NasaPictureApplication
import com.vandana.nasapictures.data.db.DatabaseService
import com.vandana.nasapictures.di.ApplicationContext
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


@Module
class ApplicationModule(private val application: NasaPictureApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun provideDatabaseService(): DatabaseService =
        Room.databaseBuilder(application, DatabaseService::class.java, "nasa_db").build()

    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()


}