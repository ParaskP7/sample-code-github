package io.petros.github.presentation.di.dagger.activity

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.petros.github.presentation.di.dagger.viewmodel.ViewModelFactory
import io.petros.github.presentation.feature.repository.RepositoryActivity
import io.petros.github.presentation.feature.repository.RepositoryActivitySubModule
import io.petros.github.presentation.feature.search.SearchActivity
import io.petros.github.presentation.feature.search.SearchActivitySubModule
import io.petros.github.presentation.feature.splash.SplashActivity
import io.petros.github.presentation.feature.splash.SplashActivitySubModule

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector(modules = [SplashActivitySubModule::class])
    abstract fun bindsSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [SearchActivitySubModule::class])
    abstract fun bindsSearchActivity(): SearchActivity

    @ContributesAndroidInjector(modules = [RepositoryActivitySubModule::class])
    abstract fun bindsRepositoryActivity(): RepositoryActivity

    /* VIEW MODEL FACTORY */

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}
