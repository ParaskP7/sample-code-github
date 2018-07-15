package io.petros.github.presentation.feature.search.navigator

import io.petros.github.presentation.feature.navigator.ActivityNavigator
import io.petros.github.presentation.feature.repository.navigator.RepositoryLauncher
import io.petros.github.presentation.feature.search.view.SharedElementRepository
import javax.inject.Inject

class SearchActivityNavigator @Inject constructor(
    private val repositoryLauncher: RepositoryLauncher
) : ActivityNavigator(), SearchNavigator {

    override fun navigate(repository: SharedElementRepository) {
        repositoryLauncher.launch(repository)
    }

}
