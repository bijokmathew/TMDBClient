package com.example.tmdbclient.data.repository.movie.datasource

import com.example.tmdbclient.data.model.movies.Movie
import com.example.tmdbclient.data.model.movies.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies():Response<MovieList>
}