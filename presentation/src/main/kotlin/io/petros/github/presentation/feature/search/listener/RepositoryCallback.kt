package io.petros.github.presentation.feature.search.listener

import io.petros.github.presentation.feature.search.view.SharedElementRepository

interface RepositoryCallback {

    fun onClick(repository: SharedElementRepository)

}
