package io.petros.github.presentation.feature.search

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.petros.github.presentation.di.dagger.activity.SubModuleBinding
import io.petros.github.presentation.di.dagger.viewmodel.ViewModelKey

@Module
abstract class SearchActivitySubModule : SubModuleBinding<SearchActivity> {

    @Binds
    @IntoMap
    @ViewModelKey(SearchActivityViewModel::class)
    abstract fun bindSearchActivityViewModel(searchActivityViewModel: SearchActivityViewModel): ViewModel

}
