package com.example.tmdbclient.data.repository.movie.datasourceImp

import com.example.tmdbclient.data.model.movies.Movie
import com.example.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImp: MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }
}