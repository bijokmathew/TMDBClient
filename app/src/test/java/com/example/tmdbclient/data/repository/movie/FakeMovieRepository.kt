package com.example.tmdbclient.data.repository.movie

import com.example.tmdbclient.data.model.movies.Movie
import com.example.tmdbclient.domain.repository.MovieRepository

class FakeMovieRepository:MovieRepository{

    private val movieList = mutableListOf<Movie>()
    init {
        movieList.add(Movie(1,"aa","aa","aa","aa"))
        movieList.add(Movie(2,"bb","bb","bb","bb"))
    }
    override suspend fun getMovies(): List<Movie> {
        return movieList
    }

    override suspend fun updateMovies(): List<Movie> {
        movieList.clear()
        movieList.add(Movie(3,"ca","aa","aa","aa"))
        movieList.add(Movie(4,"db","bb","bb","bb"))
        return movieList
    }

}