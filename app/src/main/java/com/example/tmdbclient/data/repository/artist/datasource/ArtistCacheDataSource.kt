package com.example.tmdbclient.data.repository.artist.datasource

import com.example.tmdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun getPopularArtists():List<Artist>
    suspend fun savePopularArtists(artists:List<Artist>)
}