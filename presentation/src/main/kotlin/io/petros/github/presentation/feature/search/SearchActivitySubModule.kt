package io.petros.github.presentation.feature.search

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.petros.github.presentation.di.dagger.activity.SubModuleBinding
import io.petros.github.presentation.di.dagger.viewmodel.ViewModelKey
import io.petros.github.presentation.feature.repository.navigator.RepositoryActivityLauncher
import io.petros.github.presentation.feature.repository.navigator.RepositoryLauncher
import io.petros.github.presentation.feature.search.navigator.SearchActivityNavigator
import io.petros.github.presentation.feature.search.navigator.SearchNavigator

@Module
abstract class SearchActivitySubModule : SubModuleBinding<SearchActivity> {

    @Binds
    @IntoMap
    @ViewModelKey(SearchActivityViewModel::class)
    abstract fun bindSearchActivityViewModel(searchActivityViewModel: SearchActivityViewModel): ViewModel

    @Binds
    abstract fun bindSearchNavigator(searchNavigator: SearchActivityNavigator): SearchNavigator

    @Binds
    abstract fun bindRepositoryLauncher(repositoryLauncher: RepositoryActivityLauncher): RepositoryLauncher

}
