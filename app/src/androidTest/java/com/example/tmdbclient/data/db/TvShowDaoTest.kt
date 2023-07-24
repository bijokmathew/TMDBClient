package com.example.tmdbclient.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tmdbclient.data.model.tvshows.TvShow
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TvShowDaoTest {

    private lateinit var database:TMDBDatabase
    private lateinit var tvShowDao: TVShowDao
    @get:Rule
    val instantTaskExecutorRule= InstantTaskExecutorRule()

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()
        tvShowDao = database.tvShowDao()
    }

    @Test
    fun saveTvshows(){

        val tvshows = listOf<TvShow>(
            TvShow("date",1,"name","over","path"),
            TvShow("date",2,"name","over","path")
        )
        runBlocking {
            tvShowDao.saveTvshows(tvshows)
            val result = tvShowDao.getTVShows()
            Truth.assertThat(result).isEqualTo(tvshows)
        }

    }

}