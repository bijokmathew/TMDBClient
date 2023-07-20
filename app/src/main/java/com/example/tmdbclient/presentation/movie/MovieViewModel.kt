package com.example.tmdbclient.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.data.model.movies.Movie
import com.example.tmdbclient.domain.usecases.GetMoviewUseCase
import com.example.tmdbclient.domain.usecases.UpdateMovieUseCase

class MovieViewModel(
    private val getMoviewUseCase: GetMoviewUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
):ViewModel() {
    fun getMovies()= liveData{
        val moviewList = getMoviewUseCase.execute()
        emit(moviewList)
    }

    fun updateMovies(): LiveData<List<Movie>> {
        return liveData{
            val updateMovieList = updateMovieUseCase.execute()
            if (updateMovieList != null) {
                emit(updateMovieList)
            }
        }
    }

}