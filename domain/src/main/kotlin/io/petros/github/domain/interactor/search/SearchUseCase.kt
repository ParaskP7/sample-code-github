package io.petros.github.domain.interactor.search

import io.petros.github.domain.interactor.UseCaseSingle
import io.petros.github.domain.model.search.SearchResults
import io.petros.github.domain.reactive.rx.RxSchedulers
import io.petros.github.domain.repository.search.SearchRepository
import io.reactivex.Single
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val searchRepository: SearchRepository,
    rxSchedulers: RxSchedulers
) : UseCaseSingle<SearchResults, Unit>(rxSchedulers) {

    override fun buildUseCaseObservable(params: Unit): Single<SearchResults> {
        return searchRepository.search()
    }

}
