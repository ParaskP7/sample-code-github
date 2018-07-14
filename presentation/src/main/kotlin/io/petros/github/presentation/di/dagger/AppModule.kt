package io.petros.github.presentation.di.dagger

import android.content.Context
import dagger.Module
import dagger.Provides
import io.petros.github.presentation.App

@Module
class AppModule {

    @Provides
    fun provideContext(app: App): Context = app.applicationContext

}
