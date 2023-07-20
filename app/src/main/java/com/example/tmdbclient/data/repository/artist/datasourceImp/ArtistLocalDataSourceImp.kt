package com.example.tmdbclient.data.repository.artist.datasourceImp

import com.example.tmdbclient.data.db.ArtistDao
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImp(
    private val artistDao: ArtistDao
):ArtistLocalDataSource {
    override suspend fun getPopularArtists(): List<Artist> = artistDao.getArtistList()

    override suspend fun savePopularArtists(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtist(artists)
        }
    }

    override suspend fun deleteArtists() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteArists()
        }
    }
}