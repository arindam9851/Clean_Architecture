package com.example.viewpagerdemo.business.datasource.cache.history

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "history")
data class HistoryCacheEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "trackId")
    var trackId:Int,

    @ColumnInfo(name = "trackName")
    var trackName:String,

    @ColumnInfo(name = "artistName")
    var artistName:String,

    @ColumnInfo(name = "thumbnail")
    var thumbnail:String,



)
