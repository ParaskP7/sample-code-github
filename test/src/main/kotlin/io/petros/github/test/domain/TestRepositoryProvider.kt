package io.petros.github.test.domain

import io.petros.github.domain.model.search.Repository

class TestRepositoryProvider {

    companion object {

        private const val OWNER_AVATAR = "OWNER_AVATAR"
        private const val NAME = "NAME"
        private const val DESCRIPTION = "DESCRIPTION"
        private const val NUMBER_OF_FORKS = 10

        fun provideRepository(
            ownerAvatar: String = OWNER_AVATAR,
            name: String = NAME,
            description: String? = DESCRIPTION,
            numberOfForks: Int = NUMBER_OF_FORKS
        ): Repository {
            return Repository(
                ownerAvatar,
                name,
                description,
                numberOfForks
            )
        }

    }

}
