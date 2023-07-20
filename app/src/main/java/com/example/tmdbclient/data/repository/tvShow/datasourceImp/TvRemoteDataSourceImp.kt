package com.example.tmdbclient.data.repository.tvShow.datasourceImp

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.tvshows.TvShow
import com.example.tmdbclient.data.model.tvshows.TvShowList
import com.example.tmdbclient.data.repository.tvShow.datasource.TvRemoteDataSource
import retrofit2.Response

class TvRemoteDataSourceImp(
    private val tmdbService: TMDBService,
    private val api_key:String
    ):TvRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(api_key)
}