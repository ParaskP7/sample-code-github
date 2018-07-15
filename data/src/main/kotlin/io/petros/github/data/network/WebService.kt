package io.petros.github.data.network

import io.petros.github.domain.model.repository.RepositoryDetails
import io.petros.github.domain.model.search.Repository
import io.petros.github.domain.model.search.SearchResults
import io.petros.github.domain.model.subscriber.SubscriberResults
import io.reactivex.Single

interface WebService {

    fun search(searchTerm: String): Single<SearchResults>

    fun repositoryDetails(repository: Repository): Single<RepositoryDetails>

    fun subscribers(repository: Repository): Single<SubscriberResults>

}
