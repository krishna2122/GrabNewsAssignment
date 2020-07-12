package com.grab.assignment.krishna.di

import android.app.Application
import androidx.room.Room
import com.grab.assignment.krishna.api.NewsDataService
import com.grab.assignment.krishna.db.NewsArticlesDao
import com.grab.assignment.krishna.db.NewsDatabase
import com.grab.assignment.krishna.utils.LiveDataAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideNewsService(): NewsDataService {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataAdapterFactory())
                .build()
                .create(NewsDataService::class.java)
    }

    @Singleton
    @Provides
    fun provideDb(app: Application): NewsDatabase {
        return Room.databaseBuilder(app, NewsDatabase::class.java, "news-db").build()
    }

    @Singleton
    @Provides
    fun provideUserDao(db: NewsDatabase): NewsArticlesDao {
        return db.newsArticlesDao()
    }

    companion object {
        private const val BASE_URL = "https://newsapi.org/v2/"
    }
}
