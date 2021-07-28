package com.example.viewpagerdemo.business.datasource.network.videoresponses

import com.example.viewpagerdemo.business.domain.VideoModel
import com.example.viewpagerdemo.presentation.util.EntityMapper
import javax.inject.Inject

class VideoResponseMapper
@Inject
constructor() : EntityMapper<ResultNetworkEntity,VideoModel> {
    override fun mapFromEntity(entity: ResultNetworkEntity): VideoModel {
        return VideoModel(
            trackId = entity.trackId,
            trackName = entity.trackName,
            artistName = entity.artistName,
            thumbnail = entity.artworkUrl100
        )
    }

    override fun mapToEntity(domainModel: VideoModel): ResultNetworkEntity {
        return ResultNetworkEntity(
            trackId = domainModel.trackId,
            trackName = domainModel.trackName,
            artistName = domainModel.artistName,
            artworkUrl100 = domainModel.thumbnail
        )
    }
    fun mapFromEntityList(entities: List<ResultNetworkEntity>): List<VideoModel>{
        return entities.map { mapFromEntity(it) }
    }
}
