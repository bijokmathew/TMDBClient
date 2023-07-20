package com.example.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclient.data.model.tvshows.TvShow

@Dao
interface TVShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvshows(tvShows:List<TvShow>)

    @Query("DELETE FROM popular_tvShow")
    suspend fun deleteTvShows()

    @Query("SELECT * FROM popular_tvShow")
    fun getTVShows():List<TvShow>
}