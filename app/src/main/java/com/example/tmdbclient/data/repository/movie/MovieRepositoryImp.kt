package com.example.tmdbclient.data.repository.movie

import android.util.Log
import com.example.tmdbclient.data.model.movies.Movie
import com.example.tmdbclient.data.model.movies.MovieList
import com.example.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.domain.repository.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MovieRepositoryImp(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
): MovieRepository {
    override suspend fun getMovies(): List<Movie> = getMoviesFromCache()

    override suspend fun updateMovies(): List<Movie> {
        val newMovieList = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newMovieList)
        movieCacheDataSource.saveMoviesToCache(newMovieList)
        return  newMovieList
    }

    private suspend fun getMoviesFromAPI():List<Movie>{
        Log.i("MyTag","getMoviesFromAPI")
        lateinit var movieList:List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body:MovieList? = response.body()
            if(body != null) {
                movieList = body.movies
            }

        } catch (e:Exception){
            Log.i("MyTag",e.message.toString())
        }
        return movieList
    }

    private suspend fun getMoviesFromDB():List<Movie> {
        Log.i("MyTag","getMoviesFromDB")
        lateinit var movieList:List<Movie>
        try {
                movieList = movieLocalDataSource.getMoviesFromDB()

        } catch (e:Exception) {
            Log.i("MyTag",e.message.toString())
        }
        Log.i("MyTag","getMoviesFromDB size = ${movieList.size}")
        if(movieList.size>0){
            return  movieList
        } else{
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    private suspend fun getMoviesFromCache():List<Movie>{
        Log.i("MyTag","getMoviesFromCache")
        lateinit var movieList: List<Movie>
        try{
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (e:Exception){
            Log.i("MyTag",e.message.toString())
        }
        if(movieList.size>0){
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}