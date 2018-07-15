package io.petros.github.data.network.rest.mapper.search

import io.petros.github.data.network.rest.response.repository.Repo
import io.petros.github.data.network.rest.response.repository.RepositoryResultsResponse
import io.petros.github.domain.model.repository.Repository
import io.petros.github.domain.model.repository.RepositoryResults

class SearchMapper { // MIT

    companion object {

        internal fun transform(repositoryResultsResponse: RepositoryResultsResponse): RepositoryResults {
            val repositories = arrayListOf<Repository>()
            for (repo in repositoryResultsResponse.items) {
                repositories.add(repo.toRepository())
            }
            return RepositoryResults(repositories)
        }

    }

}

fun Repo.toRepository(): Repository {
    return Repository(
        id = id,
        ownerAvatar = owner.avatar_url,
        login = owner.login,
        name = name,
        description = description,
        numberOfForks = forks_count,
        subscribersUrl = subscribers_url
    )
}
