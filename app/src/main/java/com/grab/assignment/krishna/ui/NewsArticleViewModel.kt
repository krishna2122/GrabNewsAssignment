package com.grab.assignment.krishna.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.grab.assignment.krishna.Resource
import com.grab.assignment.krishna.model.NewsArticles
import com.grab.assignment.krishna.repository.NewsDataRepository
import javax.inject.Inject

/**
 * A container for [NewsArticles] related data to show on the UI.
 */
/**
 * The News adapter to show the news in a list.
 *
 * @author Krishna.mishra
 * @since 11/07/2020.
 */

class NewsArticleViewModel @Inject constructor(newsRepository: NewsDataRepository) : ViewModel() {

    private var newsArticles: LiveData<Resource<List<NewsArticles>?>> = newsRepository.getNewsArticles()

    /**
     * Return news articles to observe on the UI.
     */
    fun getNewsArticles() = newsArticles
}