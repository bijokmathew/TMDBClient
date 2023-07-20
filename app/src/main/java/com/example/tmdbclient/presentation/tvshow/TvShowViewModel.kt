package com.example.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.usecases.GetTvShowUseCase
import com.example.tmdbclient.domain.usecases.UpdateTvShowUseCase

class TvShowViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
): ViewModel() {

    fun getTvShows()= liveData{
        val tvshows=getTvShowUseCase.execute()
        emit(tvshows)
    }

    fun updateTvshows()= liveData{
        val updatetvshows = updateTvShowUseCase.execute()
        emit(updatetvshows)
    }
}