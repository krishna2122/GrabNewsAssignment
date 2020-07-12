package com.grab.assignment.krishna.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * News Article Model describing the article details
 * fetched from news source.
 * @author Krishna.mishra
 * @since 11/07/2020.
 */

@Entity(tableName = "news_article")
data class NewsArticles(
        @PrimaryKey(autoGenerate = true) var id: Int = 0,
        @SerializedName("author") var author: String? = null,
        @SerializedName("title") var title: String? = null,
        @SerializedName("description") var description: String? = null,
        @SerializedName("url") var url: String? = null,
        @SerializedName("urlToImage") var urlToImage: String? = null,
        @SerializedName("publishedAt") var publishedAt: String? = null)