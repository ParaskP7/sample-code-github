package io.petros.github.domain.repository.repository

import io.petros.github.domain.model.repository.RepositoryDetails
import io.petros.github.domain.model.search.Repository
import io.reactivex.Single

interface RepositoryRepository {

    fun repositoryDetails(repository: Repository): Single<RepositoryDetails>

}
