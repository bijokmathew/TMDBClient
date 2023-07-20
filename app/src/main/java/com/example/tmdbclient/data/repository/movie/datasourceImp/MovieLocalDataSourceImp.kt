package com.example.tmdbclient.data.repository.movie.datasourceImp

import android.util.Log
import com.example.tmdbclient.data.db.MovieDao
import com.example.tmdbclient.data.model.movies.Movie
import com.example.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class MovieLocalDataSourceImp(private val movieDao: MovieDao): MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        Log.i("MyTag","MovieLocalDataSourceImp getMoviesFromDB ")
        return movieDao.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteMovies()
        }
    }
}