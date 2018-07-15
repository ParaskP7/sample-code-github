package io.petros.github.domain.repository.repository

import io.petros.github.domain.model.repository.Repository
import io.petros.github.domain.model.repository.RepositoryDetails
import io.reactivex.Single

interface RepositoryRepository {

    fun repositoryDetails(repository: Repository): Single<RepositoryDetails>

}
