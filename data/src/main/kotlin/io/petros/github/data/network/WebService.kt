package io.petros.github.data.network

import io.petros.github.domain.model.search.SearchResults
import io.reactivex.Single

interface WebService {

    fun search(searchTerm: String): Single<SearchResults>

}
