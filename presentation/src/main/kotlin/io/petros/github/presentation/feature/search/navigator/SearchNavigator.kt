package io.petros.github.presentation.feature.search.navigator

import io.petros.github.domain.model.search.Repository

interface SearchNavigator {

    fun navigate(repository: Repository)

}
