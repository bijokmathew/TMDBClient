package com.example.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.usecases.GetTvShowUseCase
import com.example.tmdbclient.domain.usecases.UpdateTvShowUseCase

class TvShowViewmodelFactory(
    val getTvShowUseCase: GetTvShowUseCase,
    val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUseCase,updateTvShowUseCase) as T
    }
}