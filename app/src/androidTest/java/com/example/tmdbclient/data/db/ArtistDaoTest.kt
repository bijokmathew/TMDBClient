package com.example.tmdbclient.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tmdbclient.data.model.artist.Artist
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ArtistDaoTest {
    private lateinit var database:TMDBDatabase
    private lateinit var artistDao: ArtistDao

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()
        artistDao = database.artistDao()
    }

    @Test
    fun saveArtist(){
        val artistList = listOf<Artist>(
            Artist(1,"ty",89.2,"tyyy"),
            Artist(2,"ty",89.2,"tyyy"),
            Artist(3,"ty",89.2,"tyyy")
        )
        runBlocking {
            artistDao.saveArtist(artistList)
            val result = artistDao.getArtistList()
            Truth.assertThat(result).isEqualTo(artistList)
        }
    }

    @Test
    fun deleteArtist(){
        val artistList = listOf<Artist>(
            Artist(1,"ty",89.2,"tyyy"),
            Artist(2,"ty",89.2,"tyyy"),
            Artist(3,"ty",89.2,"tyyy")
        )
        runBlocking {
            artistDao.saveArtist(artistList)
            artistDao.deleteArists()
            val artist = artistDao.getArtistList()
            Truth.assertThat(artist).isEmpty()
        }
    }

    @After
    fun tearDown() {
        database.close()
    }
}