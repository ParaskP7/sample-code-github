package io.petros.github.presentation.feature.search.subscriber

import android.arch.lifecycle.MutableLiveData
import io.petros.github.domain.model.search.RepositoryResults
import io.petros.github.presentation.feature.common.list.adapter.AdapterStatus
import io.reactivex.observers.DisposableSingleObserver
import timber.log.Timber

class SearchSubscriber(
    val statusObservable: MutableLiveData<AdapterStatus>,
    val repositoriesObservable: MutableLiveData<RepositoryResults>
) : DisposableSingleObserver<RepositoryResults>() {

    override fun onSuccess(repositoryResults: RepositoryResults) {
        Timber.d("Search repositories success. [Repository Results: $repositoryResults]")
        statusObservable.postValue(AdapterStatus.IDLE)
        repositoriesObservable.postValue(repositoryResults)
    }

    override fun onError(exception: Throwable) {
        Timber.w(exception, "Search repositories error.")
        statusObservable.postValue(AdapterStatus.ERROR)
    }

}
