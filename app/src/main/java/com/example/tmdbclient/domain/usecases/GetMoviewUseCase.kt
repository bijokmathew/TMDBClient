package com.example.tmdbclient.domain.usecases

import com.example.tmdbclient.data.model.movies.Movie
import com.example.tmdbclient.domain.repository.MovieRepository

class GetMoviewUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.getMovies()

}