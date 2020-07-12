package com.grab.assignment.krishna.di

import android.app.Application
import com.grab.assignment.krishna.GrabAssignmentNewsApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            // Dagger support
            AndroidInjectionModule::class,
            // App
            AppModule::class,
            ActivityModule::class,
            ViewModelModule::class
        ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(newsApp: GrabAssignmentNewsApp)
}
