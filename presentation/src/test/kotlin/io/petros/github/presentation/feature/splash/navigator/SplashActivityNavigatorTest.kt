package io.petros.github.presentation.feature.splash.navigator

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.petros.github.presentation.feature.navigator.Launcher
import io.petros.github.presentation.feature.search.navigator.SearchLauncher
import org.junit.Before
import org.junit.Test

class SplashActivityNavigatorTest {

    private val searchLauncherMock = mock<SearchLauncher>()
    private val launcherMock = mock<Launcher>()

    private lateinit var testedClass: SplashActivityNavigator

    @Before
    fun setUp() {
        testedClass = SplashActivityNavigator(searchLauncherMock)
        testedClass.launcher = launcherMock
    }

    @Test
    fun `When navigating from splash activity, then search activity launches`() {
        testedClass.navigate()

        verify(searchLauncherMock).launch()
    }

    @Test
    fun `When navigating from splash activity, then splash activity finishes`() {
        testedClass.navigate()

        verify(launcherMock).finish()
    }

}
