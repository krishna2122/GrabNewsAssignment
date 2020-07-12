package com.grab.assignment.krishna.api

import com.grab.assignment.krishna.api.BaseServiceTest
import com.grab.assignment.krishna.api.NewsDataService
import com.grab.assignment.krishna.utils.LiveDataAdapterFactory
import com.grab.assignment.krishna.utils.LiveDataTestUtil
import com.grab.assignment.krishna.utils.create
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

/**
 *
 * @author Krishna Mishra
 * @since 08/11/2019.
 * @version 1.0
 */
@RunWith(JUnit4::class)
class NewsSourceServiceTest : BaseServiceTest() {

    private lateinit var service: NewsDataService

    @Before
    @Throws(IOException::class)
    fun createService() {
        service = Retrofit.Builder()
                .baseUrl(mockWebServer.url("/"))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataAdapterFactory())
                .build()
                .create();
    }

    @Test
    @Throws(IOException::class, InterruptedException::class)
    fun getNewsSource() {
        enqueueResponse("news_source.json")
        val newsSource = LiveDataTestUtil.getValue(service.getNewsSource()).data

        // Dummy request
        mockWebServer.takeRequest()

        // Check news source
        assertThat(newsSource, notNullValue())
        assertThat(newsSource?.source, `is`("grab-news"))
        assertThat(newsSource?.sortBy, `is`("top"))
        assertThat(newsSource?.status, `is`("ok"))

        // Check list
        val articles = newsSource?.articles
        assertThat(articles, notNullValue())

        // Check item 1
        val article1 = articles?.get(0)
        assertThat(article1, notNullValue())
        if (article1 != null) {
            assertThat(article1.author, `is`("Krishna.mishra"))
            assertThat(article1.title, `is`("Grab News Assignment"))
            assertThat(article1.description, `is`("Grab news assignment was funtastic ;)"))
        }
    }
}