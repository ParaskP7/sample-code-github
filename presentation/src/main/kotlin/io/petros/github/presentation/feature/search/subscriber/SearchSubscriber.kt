package io.petros.github.presentation.feature.search.subscriber

import android.arch.lifecycle.MutableLiveData
import io.petros.github.domain.model.search.SearchResults
import io.reactivex.observers.DisposableSingleObserver
import timber.log.Timber

class SearchSubscriber(
    private val searchResultsObservable: MutableLiveData<SearchResults>
) : DisposableSingleObserver<SearchResults>() {

    override fun onSuccess(searchResults: SearchResults) {
        Timber.d("Search success. [Search Results: $searchResults]")
        searchResultsObservable.postValue(searchResults)
    }

    override fun onError(exception: Throwable) {
        Timber.w(exception, "Search error.")
    }

}
