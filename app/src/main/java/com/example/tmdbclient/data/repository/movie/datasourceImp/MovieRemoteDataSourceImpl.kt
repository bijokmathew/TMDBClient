package com.example.tmdbclient.data.repository.movie.datasourceImp

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.movies.Movie
import com.example.tmdbclient.data.model.movies.MovieList
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
        private val tmdbService: TMDBService,
        private val api_key:String
        ):MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(api_key)
    }
}