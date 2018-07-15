package io.petros.github.data.repository.search

import io.petros.github.data.network.WebService
import io.petros.github.domain.model.repository.RepositoryResults
import io.petros.github.domain.repository.search.SearchRepository
import io.reactivex.Single
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val webService: WebService
) : SearchRepository {

    override fun search(searchTerm: String): Single<RepositoryResults> {
        return webService.search(searchTerm)
    }

}
