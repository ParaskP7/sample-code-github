package io.petros.github.data.network.rest

import io.petros.github.data.network.WebService
import io.petros.github.data.network.rest.mapper.repository.RepositoryMapper
import io.petros.github.data.network.rest.mapper.search.SearchMapper
import io.petros.github.data.network.rest.mapper.subscriber.SubscriberMapper
import io.petros.github.domain.model.repository.Repository
import io.petros.github.domain.model.repository.RepositoryDetails
import io.petros.github.domain.model.repository.RepositoryResults
import io.petros.github.domain.model.subscriber.SubscriberResults
import io.reactivex.Single
import javax.inject.Inject

class RestClient @Inject constructor(
    private val restApi: RestApi
) : WebService {

    override fun searchRepositories(searchTerm: String): Single<RepositoryResults> {
        return restApi.searchRepositories(searchTerm)
            .map { SearchMapper.transform(it) }
    }

    override fun repositoryDetails(repository: Repository): Single<RepositoryDetails> {
        return restApi.repositoryDetails(repository.login, repository.name)
            .map { RepositoryMapper.transform(it) }
    }

    override fun subscribers(repository: Repository): Single<SubscriberResults> {
        return restApi.subscribers(repository.login, repository.name)
            .map { SubscriberMapper.transform(it) }
    }

}
