package io.petros.github.presentation.feature.search.listener

import io.petros.github.domain.model.search.Repository

interface RepositoryCallback {

    fun onClick(repository: Repository)

}
