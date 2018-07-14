package io.petros.github.presentation.feature.splash.navigator

import io.petros.github.presentation.feature.navigator.ActivityNavigator
import io.petros.github.presentation.feature.search.navigator.SearchLauncher
import javax.inject.Inject

class SplashActivityNavigator @Inject constructor(
    private val searchLauncher: SearchLauncher
) : ActivityNavigator(), SplashNavigator {

    override fun navigate() {
        searchLauncher.launch()
        launcher.finish()
    }

}
