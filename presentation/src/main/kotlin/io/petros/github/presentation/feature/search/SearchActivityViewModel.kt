package io.petros.github.presentation.feature.search

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.annotation.VisibleForTesting
import io.petros.github.domain.interactor.search.SearchUseCase
import io.petros.github.domain.model.repository.RepositoryResults
import io.petros.github.presentation.feature.common.list.adapter.AdapterStatus
import io.petros.github.presentation.feature.search.subscriber.SearchSubscriber
import javax.inject.Inject

class SearchActivityViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
) : ViewModel() {

    val statusObservable = MutableLiveData<AdapterStatus>()
    val repositoriesObservable = MutableLiveData<RepositoryResults>()

    fun search(searchTerm: String) {
        statusObservable.postValue(AdapterStatus.LOADING)
        searchUseCase.execute(
            SearchSubscriber(statusObservable, repositoriesObservable),
            SearchUseCase.Params.with(searchTerm)
        )
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public override fun onCleared() {
        super.onCleared()
        searchUseCase.dispose()
    }

}
