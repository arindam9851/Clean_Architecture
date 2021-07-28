package com.example.viewpagerdemo.di

import android.content.Context
import androidx.room.Room
import com.example.viewpagerdemo.business.datasource.cache.AppDao
import com.example.viewpagerdemo.business.datasource.cache.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {


    @Singleton
    @Provides
    fun provideTrendingDb(@ApplicationContext context: Context):AppDatabase{
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideTrendingDao(appDatabase: AppDatabase):AppDao{
        return appDatabase.appDao()
    }

}