package io.petros.github.data.network.rest

import io.petros.github.data.network.WebService
import io.petros.github.data.network.rest.mapper.search.SearchMapper
import io.petros.github.domain.model.search.SearchResults
import io.reactivex.Single
import javax.inject.Inject

class RestClient @Inject constructor(
    private val restApi: RestApi
) : WebService {

    override fun search(searchTerm: String): Single<SearchResults> {
        return restApi.search(searchTerm)
            .map { SearchMapper.transform(it) }
    }

}
