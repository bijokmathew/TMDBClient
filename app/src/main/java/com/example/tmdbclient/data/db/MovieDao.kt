package com.example.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclient.data.model.movies.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movieList:List<Movie>)

    @Query("DELETE FROM popular_movie")
    suspend fun deleteMovies()

    @Query("SELECT * FROM popular_movie")
    suspend fun getMovies():List<Movie>
}