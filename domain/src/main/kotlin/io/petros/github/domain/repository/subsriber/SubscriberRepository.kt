package io.petros.github.domain.repository.subsriber

import io.petros.github.domain.model.search.Repository
import io.petros.github.domain.model.subscriber.SubscriberResults
import io.reactivex.Single

interface SubscriberRepository {

    fun subscribers(repository: Repository): Single<SubscriberResults>

}
