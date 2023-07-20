package com.example.tmdbclient.presentation.di.tvshow

import com.example.tmdbclient.domain.usecases.GetTvShowUseCase
import com.example.tmdbclient.domain.usecases.UpdateTvShowUseCase
import com.example.tmdbclient.presentation.tvshow.TvShowViewmodelFactory
import dagger.Module
import dagger.Provides

@Module
class TvshowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowUseCase: GetTvShowUseCase,
        upateTvShowUseCase: UpdateTvShowUseCase
    ):TvShowViewmodelFactory{
        return TvShowViewmodelFactory(
            getTvShowUseCase,
            upateTvShowUseCase
        )
    }

}