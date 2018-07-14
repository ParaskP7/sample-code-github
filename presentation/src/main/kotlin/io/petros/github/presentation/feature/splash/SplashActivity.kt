package io.petros.github.presentation.feature.splash

import android.os.Bundle
import io.petros.github.presentation.feature.BaseActivity
import io.petros.github.presentation.feature.splash.navigator.SplashNavigator
import javax.inject.Inject

class SplashActivity : BaseActivity<SplashActivityViewModel>() {

    @Inject lateinit var splashNavigator: SplashNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashNavigator.navigate()
    }

    /* OBSERVERS */

    /* CONTRACT */

    override fun constructContentView(): Int? = null

    override fun constructViewModel(): Class<SplashActivityViewModel> = SplashActivityViewModel::class.java

}
