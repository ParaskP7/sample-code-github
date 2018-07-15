package io.petros.github.test.domain

import io.petros.github.domain.model.repository.Repository
import io.petros.github.domain.model.repository.RepositoryResults
import io.petros.github.test.domain.TestRepositoryProvider.Companion.provideRepository

class TestSearchResultsProvider {

    companion object {

        const val SEARCH_TERM = "SEARCH_TERM"

        fun provideRepositoryResults(
            repositories: List<Repository> = arrayListOf(provideRepository(), provideRepository(), provideRepository())
        ): RepositoryResults {
            return RepositoryResults(
                repositories
            )
        }

    }

}
