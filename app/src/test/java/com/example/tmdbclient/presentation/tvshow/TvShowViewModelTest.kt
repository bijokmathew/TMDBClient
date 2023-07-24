package com.example.tmdbclient.presentation.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tmdbclient.data.model.tvshows.TvShow
import com.example.tmdbclient.data.repository.tvShow.FakeTvShowrepository
import com.example.tmdbclient.domain.usecases.GetTvShowUseCase
import com.example.tmdbclient.domain.usecases.UpdateTvShowUseCase
import com.example.tmdbclient.getOrAwaitValue
import com.google.common.truth.Truth
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TvShowViewModelTest{

    private lateinit var viewModel: TvShowViewModel
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        val fakeTvShowrepository = FakeTvShowrepository()
        val getTvShowUseCase = GetTvShowUseCase(fakeTvShowrepository)
        val updateTvShowUseCase = UpdateTvShowUseCase(fakeTvShowrepository)
        viewModel = TvShowViewModel(getTvShowUseCase,updateTvShowUseCase)

    }

    @Test
    fun getTvShows(){
        val tvShows = mutableListOf<TvShow>()
        tvShows.add(TvShow("date",1,"name","overv","path"))
        tvShows.add(TvShow("date",2,"name","overv","path"))
        val result = viewModel.getTvShows().getOrAwaitValue()
        Truth.assertThat(result).isEqualTo(tvShows)
    }
}