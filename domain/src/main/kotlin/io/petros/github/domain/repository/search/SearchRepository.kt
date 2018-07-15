package io.petros.github.domain.repository.search

import io.petros.github.domain.model.repository.RepositoryResults
import io.reactivex.Single

interface SearchRepository {

    fun searchRepositories(searchTerm: String): Single<RepositoryResults>

}
