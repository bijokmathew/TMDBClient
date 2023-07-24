package com.example.tmdbclient.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tmdbclient.data.model.movies.Movie
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    private lateinit var movieDao: MovieDao
    private lateinit var database:TMDBDatabase
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @Before
    fun setUp() {
         database = Room.inMemoryDatabaseBuilder(
             ApplicationProvider.getApplicationContext(),
             TMDBDatabase::class.java
         ).build()
        movieDao = database.movieDao()

    }

    @Test
    fun saveMovies_test():Unit= runBlocking{
        val movies = listOf<Movie>(
            Movie(0,"val","url","67","Bijo"),
            Movie(1,"val","url","67","Lijo")
        )
        movieDao.saveMovies(movies)
        val result:List<Movie> = movieDao.getMovies()
        Truth.assertThat(result).isEqualTo(movies)
    }

    @After
    fun tearDown() {

        database.close()
    }
}