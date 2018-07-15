package io.petros.github.presentation.feature.search.navigator

import io.petros.github.presentation.feature.search.view.SharedElementRepository

interface SearchNavigator {

    fun navigate(repository: SharedElementRepository)

}
