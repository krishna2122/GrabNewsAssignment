package com.grab.assignment.krishna.repository

import androidx.lifecycle.LiveData
import com.grab.assignment.krishna.AppExecutors
import com.grab.assignment.krishna.Resource
import com.grab.assignment.krishna.api.NewsDataService
import com.grab.assignment.krishna.db.NewsArticlesDao
import com.grab.assignment.krishna.model.NewsArticles
import com.grab.assignment.krishna.model.NewsSource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository abstracts the logic of fetching the data and persisting it for
 * offline. They are the data source as the single source of truth.
 *
 * @author Krishna Mishra
 * @since 11/07/2020.
 */

@Singleton
class NewsDataRepository @Inject constructor(
        private val newsDao: NewsArticlesDao,
        private val newsSourceService: NewsDataService,
        private val appExecutors: AppExecutors = AppExecutors()
) {

    /**
     * Fetch the news articles from database if exist else fetch from web
     * and persist them in the database
     */

    fun getNewsArticles(): LiveData<Resource<List<NewsArticles>?>> {
        return object : NetworkBoundResource<List<NewsArticles>, NewsSource>(appExecutors) {
            override fun saveCallResult(item: NewsSource) {
                newsDao.insertArticles(item.articles)
            }

            override fun shouldFetch(data: List<NewsArticles>?) = true

            override fun loadFromDb() = newsDao.getNewsArticles()

            override fun createCall() = newsSourceService.getNewsSource()
        }.asLiveData()
    }

}