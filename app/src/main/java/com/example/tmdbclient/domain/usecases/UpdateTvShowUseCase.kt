package com.example.tmdbclient.domain.usecases

import com.example.tmdbclient.data.model.tvshows.TvShow
import com.example.tmdbclient.domain.repository.TvShowRepository

class UpdateTvShowUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute():List<TvShow>? = tvShowRepository.updateTvShows()
}