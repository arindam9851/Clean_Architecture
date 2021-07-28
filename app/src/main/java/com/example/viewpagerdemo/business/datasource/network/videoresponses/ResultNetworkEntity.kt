package com.example.viewpagerdemo.business.datasource.network.videoresponses


import com.google.gson.annotations.SerializedName

data class ResultNetworkEntity(
    @SerializedName("artistId")
    var artistId: Int = 0,
    @SerializedName("artistName")
    var artistName: String = "",
    @SerializedName("artistViewUrl")
    var artistViewUrl: String = "",
    @SerializedName("artworkUrl100")
    var artworkUrl100: String = "",
    @SerializedName("artworkUrl30")
    var artworkUrl30: String = "",
    @SerializedName("artworkUrl60")
    var artworkUrl60: String = "",
    @SerializedName("collectionArtistId")
    var collectionArtistId: Int = 0,
    @SerializedName("collectionArtistViewUrl")
    var collectionArtistViewUrl: String = "",
    @SerializedName("collectionCensoredName")
    var collectionCensoredName: String = "",
    @SerializedName("collectionExplicitness")
    var collectionExplicitness: String = "",
    @SerializedName("collectionId")
    var collectionId: Int = 0,
    @SerializedName("collectionName")
    var collectionName: String = "",
    @SerializedName("collectionPrice")
    var collectionPrice: Double = 0.0,
    @SerializedName("collectionViewUrl")
    var collectionViewUrl: String = "",
    @SerializedName("country")
    var country: String = "",
    @SerializedName("currency")
    var currency: String = "",
    @SerializedName("discCount")
    var discCount: Int = 0,
    @SerializedName("discNumber")
    var discNumber: Int = 0,
    @SerializedName("kind")
    var kind: String = "",
    @SerializedName("previewUrl")
    var previewUrl: String = "",
    @SerializedName("primaryGenreName")
    var primaryGenreName: String = "",
    @SerializedName("releaseDate")
    var releaseDate: String = "",
    @SerializedName("trackCensoredName")
    var trackCensoredName: String = "",
    @SerializedName("trackCount")
    var trackCount: Int = 0,
    @SerializedName("trackExplicitness")
    var trackExplicitness: String = "",
    @SerializedName("trackId")
    var trackId: Int = 0,
    @SerializedName("trackName")
    var trackName: String = "",
    @SerializedName("trackNumber")
    var trackNumber: Int = 0,
    @SerializedName("trackPrice")
    var trackPrice: Double = 0.0,
    @SerializedName("trackTimeMillis")
    var trackTimeMillis: Int = 0,
    @SerializedName("trackViewUrl")
    var trackViewUrl: String = "",
    @SerializedName("wrapperType")
    var wrapperType: String = ""
)