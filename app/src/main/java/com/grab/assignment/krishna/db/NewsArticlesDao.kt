package com.grab.assignment.krishna.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.grab.assignment.krishna.model.NewsArticles

/**
 * Abstracts access to the news database
 *
 * @author Krishna.mishra
 * @since 11/07/2020.
 */

@Dao
interface NewsArticlesDao {

    /**
     * Insert articles into the database
     */
    @Insert
    fun insertArticles(articles: List<NewsArticles>): List<Long>

    /**
     * Get all the articles from database
     */
    @Query("SELECT * FROM news_article")
    fun getNewsArticles(): LiveData<List<NewsArticles>>
}