package io.petros.github.presentation.feature.repository

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.annotation.VisibleForTesting
import io.petros.github.domain.interactor.repository.RepositoryDetailsUseCase
import io.petros.github.domain.interactor.subscriber.SubscribersUseCase
import io.petros.github.domain.model.repository.Repository
import io.petros.github.domain.model.repository.RepositoryDetails
import io.petros.github.domain.model.subscriber.SubscriberResults
import io.petros.github.presentation.feature.common.list.adapter.AdapterStatus
import io.petros.github.presentation.feature.repository.subscriber.RepositoryDetailsSubscriber
import io.petros.github.presentation.feature.repository.subscriber.SubscribersSubscriber
import javax.inject.Inject

class RepositoryActivityViewModel @Inject constructor(
    private val repositoryDetailsUseCase: RepositoryDetailsUseCase,
    private val subscribersUseCase: SubscribersUseCase
) : ViewModel() {

    val detailsObservable = MutableLiveData<RepositoryDetails>()

    val statusObservable = MutableLiveData<AdapterStatus>()
    val subscribersObservable = MutableLiveData<SubscriberResults>()

    fun load(repository: Repository) {
        loadDetails(repository)
        loadSubscribers(repository)
    }

    private fun loadDetails(repository: Repository) {
        repositoryDetailsUseCase.execute(
            RepositoryDetailsSubscriber(detailsObservable),
            RepositoryDetailsUseCase.Params.with(repository)
        )
    }

    private fun loadSubscribers(repository: Repository) {
        statusObservable.postValue(AdapterStatus.LOADING)
        subscribersUseCase.execute(
            SubscribersSubscriber(statusObservable, subscribersObservable),
            SubscribersUseCase.Params.with(repository)
        )
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public override fun onCleared() {
        super.onCleared()
        repositoryDetailsUseCase.dispose()
        subscribersUseCase.dispose()
    }

}
