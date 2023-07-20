package com.example.tmdbclient.data.repository.tvShow.datasourceImp

import com.example.tmdbclient.data.db.TVShowDao
import com.example.tmdbclient.data.model.tvshows.TvShow
import com.example.tmdbclient.data.repository.tvShow.datasource.TvLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvLocalDataSourceImp(
    private val tvShowDao: TVShowDao
): TvLocalDataSource{
    override suspend fun getTvShows(): List<TvShow> = tvShowDao.getTVShows()

    override suspend fun saveTvShows(TvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvshows(TvShows)
        }
    }

    override suspend fun deleteTvShows() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteTvShows()
        }
    }
}