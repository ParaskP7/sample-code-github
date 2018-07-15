package io.petros.github.data.repository.subscriber

import io.petros.github.data.network.WebService
import io.petros.github.domain.model.search.Repository
import io.petros.github.domain.model.subscriber.SubscriberResults
import io.petros.github.domain.repository.subsriber.SubscriberRepository
import io.reactivex.Single
import javax.inject.Inject

class SubscriberRepositoryImpl @Inject constructor(
    private val webService: WebService
) : SubscriberRepository {

    override fun subscribers(repository: Repository): Single<SubscriberResults> {
        return webService.subscribers(repository)
    }

}
