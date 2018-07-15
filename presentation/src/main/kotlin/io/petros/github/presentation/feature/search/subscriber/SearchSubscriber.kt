package io.petros.github.presentation.feature.search.subscriber

import android.arch.lifecycle.MutableLiveData
import io.petros.github.domain.model.search.SearchResults
import io.petros.github.presentation.feature.common.list.adapter.AdapterStatus
import io.reactivex.observers.DisposableSingleObserver
import timber.log.Timber

class SearchSubscriber(
    val statusObservable: MutableLiveData<AdapterStatus>,
    val resultsObservable: MutableLiveData<SearchResults>
) : DisposableSingleObserver<SearchResults>() {

    override fun onSuccess(searchResults: SearchResults) {
        Timber.d("Search success. [Search Results: $searchResults]")
        statusObservable.postValue(AdapterStatus.IDLE)
        resultsObservable.postValue(searchResults)
    }

    override fun onError(exception: Throwable) {
        Timber.w(exception, "Search error.")
        statusObservable.postValue(AdapterStatus.ERROR)
    }

}
