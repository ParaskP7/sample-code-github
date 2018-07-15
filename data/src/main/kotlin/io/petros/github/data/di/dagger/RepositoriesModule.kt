package io.petros.github.data.di.dagger

import dagger.Binds
import dagger.Module
import io.petros.github.data.repository.repository.RepositoryRepositoryImpl
import io.petros.github.data.repository.search.SearchRepositoryImpl
import io.petros.github.data.repository.subscriber.SubscriberRepositoryImpl
import io.petros.github.domain.repository.repository.RepositoryRepository
import io.petros.github.domain.repository.search.SearchRepository
import io.petros.github.domain.repository.subsriber.SubscriberRepository

@Module
abstract class RepositoriesModule {

    @Binds
    abstract fun bindSearchRepository(searchRepository: SearchRepositoryImpl): SearchRepository

    @Binds
    abstract fun bindRepositoryRepository(repositoryRepository: RepositoryRepositoryImpl): RepositoryRepository

    @Binds
    abstract fun bindSubscriberRepository(subscriberRepository: SubscriberRepositoryImpl): SubscriberRepository

}
