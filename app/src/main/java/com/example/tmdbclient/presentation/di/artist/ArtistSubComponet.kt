package com.example.tmdbclient.presentation.di.artist

import com.example.tmdbclient.presentation.artist.ArtistActivity
import dagger.Subcomponent

@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponet {
    fun  inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponet
    }
}