package io.petros.github.presentation.feature.search.navigator

import io.petros.github.domain.model.search.Repository
import io.petros.github.presentation.feature.navigator.ActivityNavigator
import io.petros.github.presentation.feature.repository.navigator.RepositoryLauncher
import javax.inject.Inject

class SearchActivityNavigator @Inject constructor(
    private val repositoryLauncher: RepositoryLauncher
) : ActivityNavigator(), SearchNavigator {

    override fun navigate(repository: Repository) {
        repositoryLauncher.launch(repository)
    }

}
