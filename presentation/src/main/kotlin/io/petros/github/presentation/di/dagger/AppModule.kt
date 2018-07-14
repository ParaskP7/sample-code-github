package io.petros.github.presentation.di.dagger

import android.content.Context
import dagger.Module
import dagger.Provides
import io.petros.github.data.di.dagger.NetworkModule
import io.petros.github.data.di.dagger.RepositoriesModule
import io.petros.github.data.di.dagger.SchedulersModule
import io.petros.github.presentation.App

@Module(
    includes = [
        SchedulersModule::class,
        RepositoriesModule::class,
        NetworkModule::class
    ]
)
class AppModule {

    @Provides
    fun provideContext(app: App): Context = app.applicationContext

}
