package io.petros.github.presentation.feature.repository

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.petros.github.presentation.di.dagger.activity.SubModuleBinding
import io.petros.github.presentation.di.dagger.viewmodel.ViewModelKey

@Module
abstract class RepositoryActivitySubModule : SubModuleBinding<RepositoryActivity> {

    @Binds
    @IntoMap
    @ViewModelKey(RepositoryActivityViewModel::class)
    abstract fun bindRepositoryActivityViewModel(repositoryActivityViewModel: RepositoryActivityViewModel): ViewModel

}
