package io.petros.github.data.network.rest.mapper.repository

import io.petros.github.data.network.rest.response.repository.RepoDetails
import io.petros.github.domain.model.repository.RepositoryDetails

class RepositoryMapper { // MIT

    companion object {

        internal fun transform(repoDetails: RepoDetails): RepositoryDetails {
            return repoDetails.toRepositoryDetails()
        }

    }

}

fun RepoDetails.toRepositoryDetails(): RepositoryDetails {
    return RepositoryDetails(
        id = id,
        subscribersCount = subscribers_count
    )
}
