package com.example.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclient.data.model.artist.Artist

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artists:List<Artist>)

    @Query("DELETE FROM popular_artist")
    suspend fun deleteArists()

    @Query("SELECT * FROM popular_artist")
    fun getArtistList():List<Artist>
}