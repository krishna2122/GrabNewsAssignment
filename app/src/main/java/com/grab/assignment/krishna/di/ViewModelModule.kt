package com.grab.assignment.krishna.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.grab.assignment.krishna.di.base.ViewModelFactory
import com.grab.assignment.krishna.di.base.ViewModelKey
import com.grab.assignment.krishna.ui.NewsArticleViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsArticleViewModel::class)
    abstract fun bindNewsArticleViewModel(newsArticleViewModel: NewsArticleViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
