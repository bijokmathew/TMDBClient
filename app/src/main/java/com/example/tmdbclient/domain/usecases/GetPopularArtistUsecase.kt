package com.example.tmdbclient.domain.usecases

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.domain.repository.PopularArtistRepository

class GetPopularArtistUsecase(private val popularArtistRepository: PopularArtistRepository) {

    suspend fun execute():List<Artist>? = popularArtistRepository.getPopularArtist()
}