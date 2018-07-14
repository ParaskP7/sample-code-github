package io.petros.github.presentation.feature.splash

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.petros.github.presentation.di.dagger.activity.SubModuleBinding
import io.petros.github.presentation.di.dagger.viewmodel.ViewModelKey
import io.petros.github.presentation.feature.search.navigator.SearchActivityLauncher
import io.petros.github.presentation.feature.search.navigator.SearchLauncher
import io.petros.github.presentation.feature.splash.navigator.SplashActivityNavigator
import io.petros.github.presentation.feature.splash.navigator.SplashNavigator

@Module
abstract class SplashActivitySubModule : SubModuleBinding<SplashActivity> {

    @Binds
    @IntoMap
    @ViewModelKey(SplashActivityViewModel::class)
    abstract fun bindSplashActivityViewModel(splashActivityViewModel: SplashActivityViewModel): ViewModel

    @Binds
    abstract fun bindSplashNavigator(splashNavigator: SplashActivityNavigator): SplashNavigator

    @Binds
    abstract fun bindSearchLauncher(searchLauncher: SearchActivityLauncher): SearchLauncher

}
