package io.petros.github.presentation.feature.repository.navigator

import io.petros.github.domain.model.repository.Repository
import io.petros.github.presentation.feature.search.view.SharedElementRepository

interface RepositoryLauncher {

    fun launch(repository: Repository)

    fun launch(repository: SharedElementRepository)

}
