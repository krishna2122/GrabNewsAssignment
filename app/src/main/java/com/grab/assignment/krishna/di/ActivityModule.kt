package com.grab.assignment.krishna.di
import com.grab.assignment.krishna.ui.activity.NewsMainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): NewsMainActivity
}
