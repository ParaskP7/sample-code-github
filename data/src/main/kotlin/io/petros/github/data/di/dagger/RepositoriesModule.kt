package io.petros.github.data.di.dagger

import dagger.Binds
import dagger.Module
import io.petros.github.data.repository.search.SearchRepositoryImpl
import io.petros.github.domain.repository.search.SearchRepository

@Module
abstract class RepositoriesModule {

    @Binds
    abstract fun bindSearchRepository(searchRepositoryImpl: SearchRepositoryImpl): SearchRepository

}
