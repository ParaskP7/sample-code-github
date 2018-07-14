package io.petros.github.domain.repository.search

import io.petros.github.domain.model.search.SearchResults
import io.reactivex.Single

interface SearchRepository {

    fun search(): Single<SearchResults>

}
