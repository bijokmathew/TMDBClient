package com.example.tmdbclient.data.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.movies.Movie
import com.example.tmdbclient.data.model.tvshows.TvShow

@Database(
    entities = [Movie::class,Artist::class,TvShow::class],
    version = 2,
    exportSchema = true,


)
abstract class TMDBDatabase: RoomDatabase() {

    abstract fun movieDao():MovieDao
    abstract fun tvShowDao():TVShowDao
    abstract fun artistDao():ArtistDao
}