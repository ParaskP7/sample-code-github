package io.petros.github.data.network.rest.mapper.search

import io.petros.github.data.network.rest.response.search.Repo
import io.petros.github.data.network.rest.response.search.SearchResultsResponse
import io.petros.github.domain.model.search.Repository
import io.petros.github.domain.model.search.SearchResults

class SearchMapper { // MIT

    companion object {

        internal fun transform(searchResultsResponse: SearchResultsResponse): SearchResults {
            val repositories = arrayListOf<Repository>()
            for (repo in searchResultsResponse.items) {
                repositories.add(repo.toRepository())
            }
            return SearchResults(repositories)
        }

    }

}

fun Repo.toRepository(): Repository {
    return Repository(
        ownerAvatar = owner.avatar_url,
        name = name,
        description = description,
        numberOfForks = forks_count
    )
}
