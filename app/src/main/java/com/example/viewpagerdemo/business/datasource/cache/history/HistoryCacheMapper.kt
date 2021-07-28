package com.example.viewpagerdemo.business.datasource.cache.history

import com.example.viewpagerdemo.business.domain.VideoModel
import com.example.viewpagerdemo.presentation.util.EntityMapper
import javax.inject.Inject

class HistoryCacheMapper
@Inject
constructor(): EntityMapper<HistoryCacheEntity, VideoModel>

{
    override fun mapFromEntity(entity: HistoryCacheEntity): VideoModel {
        return VideoModel(
            trackId = entity.trackId,
            trackName = entity.trackName,
            artistName = entity.artistName,
            thumbnail = entity.thumbnail
        )
    }

    override fun mapToEntity(domainModel: VideoModel): HistoryCacheEntity {
        return HistoryCacheEntity(
            trackId = domainModel.trackId,
            trackName = domainModel.trackName,
            artistName = domainModel.artistName,
            thumbnail = domainModel.thumbnail
        )
    }

}