package com.example.viewpagerdemo.business.datasource.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.viewpagerdemo.business.datasource.cache.history.HistoryCacheEntity

@Database(entities = [HistoryCacheEntity::class],version = 1,exportSchema = false)
abstract class AppDatabase:RoomDatabase() {
    abstract fun appDao():AppDao

    companion object{
        const val DATABASE_NAME:String="app_db"
    }

}