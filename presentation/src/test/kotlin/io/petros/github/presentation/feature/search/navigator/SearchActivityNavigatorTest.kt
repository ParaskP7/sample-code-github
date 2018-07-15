package io.petros.github.presentation.feature.search.navigator

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.petros.github.presentation.feature.navigator.Launcher
import io.petros.github.presentation.feature.repository.navigator.RepositoryLauncher
import io.petros.github.presentation.feature.search.view.SharedElementRepository
import io.petros.github.test.domain.TestRepositoryProvider.Companion.provideRepository
import org.junit.Before
import org.junit.Test

class SearchActivityNavigatorTest {

    private val repository = provideRepository()

    private val repositoryLauncherMock = mock<RepositoryLauncher>()
    private val launcherMock = mock<Launcher>()

    private lateinit var testedClass: SearchActivityNavigator

    @Before
    fun setUp() {
        testedClass = SearchActivityNavigator(repositoryLauncherMock)
        testedClass.launcher = launcherMock
    }

    @Test
    fun `When navigating from search activity, then repository activity launches`() {
        val sharedElementRepository = SharedElementRepository(repository, mock())

        testedClass.navigate(sharedElementRepository)

        verify(repositoryLauncherMock).launch(sharedElementRepository)
    }

}
