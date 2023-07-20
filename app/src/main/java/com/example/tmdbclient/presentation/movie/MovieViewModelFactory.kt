package com.example.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.usecases.GetMoviewUseCase
import com.example.tmdbclient.domain.usecases.UpdateMovieUseCase

class MovieViewModelFactory(
    val getMoviewUseCase: GetMoviewUseCase,
    val updateMovieUseCase: UpdateMovieUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviewUseCase,updateMovieUseCase) as T
    }
}