package com.grab.assignment.krishna.model

import com.google.gson.annotations.SerializedName

/**
 * News source model describing the source details
 * and the articles under it.
 *
 * @author Krishna Mishra
 * @since 11/07/2020.
 */
data class NewsSource(
        @SerializedName("status") var status: String = "",
        @SerializedName("source") var source: String = "",
        @SerializedName("sortBy") var sortBy: String = "",
        @SerializedName("articles") var articles: List<NewsArticles> = emptyList())