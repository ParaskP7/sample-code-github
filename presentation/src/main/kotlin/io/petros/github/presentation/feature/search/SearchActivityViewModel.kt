package io.petros.github.presentation.feature.search

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.annotation.VisibleForTesting
import io.petros.github.domain.interactor.search.SearchUseCase
import io.petros.github.domain.model.search.SearchResults
import io.petros.github.presentation.feature.common.list.adapter.AdapterStatus
import io.petros.github.presentation.feature.search.subscriber.SearchSubscriber
import javax.inject.Inject

class SearchActivityViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
) : ViewModel() {

    val resultsObservable = MutableLiveData<SearchResults>()
    val statusObservable = MutableLiveData<AdapterStatus>()

    fun search(searchTerm: String) {
        statusObservable.postValue(AdapterStatus.LOADING)
        searchUseCase.execute(
            SearchSubscriber(statusObservable, resultsObservable),
            SearchUseCase.Params.with(searchTerm)
        )
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public override fun onCleared() {
        super.onCleared()
        searchUseCase.dispose()
    }

}
