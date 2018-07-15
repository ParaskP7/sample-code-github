package io.petros.github.test.domain

import io.petros.github.domain.model.repository.RepositoryDetails
import io.petros.github.domain.model.search.Repository

class TestRepositoryProvider {

    companion object {

        private const val ID = 1
        private const val OWNER_AVATAR = "OWNER_AVATAR"
        private const val LOGIN = "LOGIN"
        private const val NAME = "NAME"
        private const val DESCRIPTION = "DESCRIPTION"
        private const val NUMBER_OF_FORKS = 10
        private const val SUBSCRIBERS_URL = "SUBSCRIBERS_URL"

        private const val SUBSCRIBERS_COUNT = 10

        fun provideRepository(
            id: Int = ID,
            ownerAvatar: String = OWNER_AVATAR,
            login: String = LOGIN,
            name: String = NAME,
            description: String? = DESCRIPTION,
            numberOfForks: Int = NUMBER_OF_FORKS,
            subscribersUrl: String = SUBSCRIBERS_URL
        ): Repository {
            return Repository(
                id,
                ownerAvatar,
                login,
                name,
                description,
                numberOfForks,
                subscribersUrl
            )
        }

        fun provideRepositoryDetails(
            id: Int = ID,
            subscribersCount: Int = SUBSCRIBERS_COUNT
        ): RepositoryDetails {
            return RepositoryDetails(
                id,
                subscribersCount
            )
        }

    }

}
