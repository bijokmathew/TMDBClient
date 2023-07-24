package com.example.tmdbclient.presentation.movie


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tmdbclient.data.model.movies.Movie
import com.example.tmdbclient.data.repository.movie.FakeMovieRepository
import com.example.tmdbclient.domain.usecases.GetMoviewUseCase
import com.example.tmdbclient.domain.usecases.UpdateMovieUseCase
import com.example.tmdbclient.getOrAwaitValue
import com.google.common.truth.Truth

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MovieViewModelTest{

    private lateinit var movieViewModel: MovieViewModel
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        val movieRepositoryImpTest = FakeMovieRepository()
        val getMoviewUseCase = GetMoviewUseCase(movieRepositoryImpTest)
        val updateMovieUseCase = UpdateMovieUseCase(movieRepositoryImpTest)
        movieViewModel = MovieViewModel(getMoviewUseCase,updateMovieUseCase)
    }

    @Test
    fun getMovies_returnCurrentList(){
        val movieList = mutableListOf<Movie>()
        movieList.add(Movie(1,"aa","aa","aa","aa"))
        movieList.add(Movie(2,"bb","bb","bb","bb"))
        val result = movieViewModel.getMovies().getOrAwaitValue()
        Truth.assertThat(result).isEqualTo(movieList)
    }

}