package com.example.tmdbclient.data.repository.artist.datasourceImp

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImp:ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getPopularArtists(): List<Artist> = artistList

    override suspend fun savePopularArtists(artists: List<Artist>) {
        artistList.addAll(artists)
    }
}