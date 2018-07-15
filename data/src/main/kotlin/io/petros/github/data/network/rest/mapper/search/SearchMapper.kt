package io.petros.github.data.network.rest.mapper.search

import io.petros.github.data.network.rest.response.search.Repo
import io.petros.github.data.network.rest.response.search.SearchResultsResponse
import io.petros.github.domain.model.search.Repository
import io.petros.github.domain.model.search.RepositoryResults

class SearchMapper { // MIT

    companion object {

        internal fun transform(searchResultsResponse: SearchResultsResponse): RepositoryResults {
            val repositories = arrayListOf<Repository>()
            for (repo in searchResultsResponse.items) {
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
