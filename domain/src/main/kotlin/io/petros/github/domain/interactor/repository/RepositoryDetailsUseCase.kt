package io.petros.github.domain.interactor.repository

import io.petros.github.domain.interactor.UseCaseSingle
import io.petros.github.domain.model.repository.RepositoryDetails
import io.petros.github.domain.model.search.Repository
import io.petros.github.domain.reactive.rx.RxSchedulers
import io.petros.github.domain.repository.repository.RepositoryRepository
import io.reactivex.Single
import javax.inject.Inject

class RepositoryDetailsUseCase @Inject constructor(
    private val repositoryRepository: RepositoryRepository,
    rxSchedulers: RxSchedulers
) : UseCaseSingle<RepositoryDetails, RepositoryDetailsUseCase.Params>(rxSchedulers) {

    override fun buildUseCaseObservable(params: Params): Single<RepositoryDetails> {
        return repositoryRepository.repositoryDetails(params.repository)
    }

    data class Params constructor(val repository: Repository) {

        companion object {

            fun with(repository: Repository): Params {
                return Params(repository)
            }

        }

    }

}
