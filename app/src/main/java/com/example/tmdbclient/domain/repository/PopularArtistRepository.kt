package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.model.artist.Artist

interface PopularArtistRepository {
    suspend fun getPopularArtist():List<Artist>
    suspend fun updatePopularArtist():List<Artist>
}