package com.example.viewpagerdemo.business.datasource.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.viewpagerdemo.business.datasource.cache.history.HistoryCacheEntity

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(historyCacheEntity: HistoryCacheEntity):Long

    @Query("SELECT * FROM history")
    suspend fun getHistory():List<HistoryCacheEntity>

}