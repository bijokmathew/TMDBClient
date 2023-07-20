package com.example.tmdbclient.data.repository.tvShow.datasource

import com.example.tmdbclient.data.model.tvshows.TvShow
import com.example.tmdbclient.data.model.tvshows.TvShowList
import retrofit2.Response

interface TvRemoteDataSource {

    suspend fun getTvShows():Response<TvShowList>

}