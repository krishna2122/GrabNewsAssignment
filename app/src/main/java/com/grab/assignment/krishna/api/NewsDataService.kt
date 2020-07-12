package com.grab.assignment.krishna.api

import androidx.lifecycle.LiveData
import com.grab.assignment.krishna.BuildConfig
import com.grab.assignment.krishna.Resource
import com.grab.assignment.krishna.model.NewsSource
import retrofit2.http.GET

/**
 * Fetch all the latest news article from news API.
 *
 * @author krishna Mishra
 * @since 11/07/2020.
 */
interface NewsDataService {

    /**
     * Retrieves all the latest news article from Google news.
     */
    @GET("top-headlines?country=in&apiKey=" + BuildConfig.NEWS_API_KEY)
    fun getNewsSource(): LiveData<Resource<NewsSource>>

}
