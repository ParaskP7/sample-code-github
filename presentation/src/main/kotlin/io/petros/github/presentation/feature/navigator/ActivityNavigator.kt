package io.petros.github.presentation.feature.navigator

import javax.inject.Inject

open class ActivityNavigator : Navigator {

    @Inject lateinit var launcher: Launcher

    override fun finish() {
        launcher.finish()
    }

}
