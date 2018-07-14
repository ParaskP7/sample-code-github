package io.petros.github.presentation.feature.search

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.petros.github.domain.interactor.search.SearchUseCase
import io.petros.github.domain.model.search.SearchResults
import io.petros.github.presentation.feature.search.subscriber.SearchSubscriber
import javax.inject.Inject

class SearchActivityViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
) : ViewModel() {

    val searchResultsObservable = MutableLiveData<SearchResults>()

    fun search() {
        searchUseCase.execute(SearchSubscriber(searchResultsObservable))
    }

}
