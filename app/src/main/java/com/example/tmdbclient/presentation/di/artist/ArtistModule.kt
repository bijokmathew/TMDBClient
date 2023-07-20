package com.example.tmdbclient.presentation.di.artist

import com.example.tmdbclient.domain.usecases.GetPopularArtistUsecase
import com.example.tmdbclient.domain.usecases.UpdatePopularArtistUsecases
import com.example.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        updatePopularArtistUsecases: UpdatePopularArtistUsecases,
        getPopularArtistUsecase: GetPopularArtistUsecase
    ):ArtistViewModelFactory{
        return ArtistViewModelFactory(updatePopularArtistUsecases,getPopularArtistUsecase)
    }
}