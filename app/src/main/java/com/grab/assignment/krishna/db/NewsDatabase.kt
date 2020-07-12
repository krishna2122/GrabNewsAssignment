package com.grab.assignment.krishna.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.grab.assignment.krishna.model.NewsArticles

/**
 *
 * @author Krishna Mishra
 * @since 11/07/2020.
 */
@Database(entities = [NewsArticles::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {

    /**
     * Get news article DAO
     */
    abstract fun newsArticlesDao(): NewsArticlesDao
}