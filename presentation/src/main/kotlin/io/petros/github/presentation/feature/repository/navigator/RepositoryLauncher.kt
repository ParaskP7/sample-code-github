package io.petros.github.presentation.feature.repository.navigator

import io.petros.github.domain.model.search.Repository

interface RepositoryLauncher {

    fun launch(repository: Repository)

}
