package io.petros.github.presentation.feature.search.list

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.petros.github.presentation.feature.search.listener.RepositoryCallback
import io.petros.github.presentation.feature.search.view.RepositoryItemView
import io.petros.github.test.domain.TestRepositoryProvider.Companion.provideRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class RepositoryViewHolderRobolectricTest {

    private val repository = provideRepository()

    private val itemViewMock = mock<RepositoryItemView>()
    private val callbackMock = mock<RepositoryCallback>()

    private lateinit var testedClass: RepositoryViewHolder

    @Before
    fun setUp() {
        testedClass = RepositoryViewHolder(itemViewMock, callbackMock)
    }

    @Test
    fun `When the view holder binds a repository, then the item view is bind with a repository`() {
        testedClass.bind(repository)

        verify(itemViewMock).bind(repository)
    }

    @Test
    fun `When the view holder binds a repository, then the item view is bind with a repository callback`() {
        testedClass.bind(repository)

        verify(itemViewMock).bindCallback(repository, callbackMock)
    }

}
