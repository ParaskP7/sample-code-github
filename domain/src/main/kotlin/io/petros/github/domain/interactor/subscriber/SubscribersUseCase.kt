package io.petros.github.domain.interactor.subscriber

import io.petros.github.domain.interactor.UseCaseSingle
import io.petros.github.domain.model.search.Repository
import io.petros.github.domain.model.subscriber.SubscriberResults
import io.petros.github.domain.reactive.rx.RxSchedulers
import io.petros.github.domain.repository.subsriber.SubscriberRepository
import io.reactivex.Single
import javax.inject.Inject

class SubscribersUseCase @Inject constructor(
    private val subscriberRepository: SubscriberRepository,
    rxSchedulers: RxSchedulers
) : UseCaseSingle<SubscriberResults, SubscribersUseCase.Params>(rxSchedulers) {

    override fun buildUseCaseObservable(params: Params): Single<SubscriberResults> {
        return subscriberRepository.subscribers(params.repository)
    }

    data class Params constructor(val repository: Repository) {

        companion object {

            fun with(repository: Repository): Params {
                return Params(repository)
            }

        }

    }

}
