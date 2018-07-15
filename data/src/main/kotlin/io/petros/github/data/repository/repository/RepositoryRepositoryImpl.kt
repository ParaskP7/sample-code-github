package io.petros.github.data.repository.repository

import io.petros.github.data.network.WebService
import io.petros.github.domain.model.repository.Repository
import io.petros.github.domain.model.repository.RepositoryDetails
import io.petros.github.domain.repository.repository.RepositoryRepository
import io.reactivex.Single
import javax.inject.Inject

class RepositoryRepositoryImpl @Inject constructor(
    private val webService: WebService
) : RepositoryRepository {

    override fun repositoryDetails(repository: Repository): Single<RepositoryDetails> {
        return webService.repositoryDetails(repository)
    }

}
