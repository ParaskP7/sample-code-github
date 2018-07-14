package io.petros.github.data.repository.search

import io.petros.github.domain.model.search.SearchResults
import io.petros.github.domain.repository.search.SearchRepository
import io.reactivex.Single
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor() : SearchRepository {

    override fun search(): Single<SearchResults> {
        return Single.just(SearchResults("GitHub Search Results!"))
    }

}
