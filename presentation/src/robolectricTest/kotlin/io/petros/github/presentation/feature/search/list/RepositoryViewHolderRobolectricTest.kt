package io.petros.github.presentation.feature.search.list

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.petros.github.presentation.RobolectricTestProvider.Companion.provideContext
import io.petros.github.presentation.feature.search.listener.RepositoryCallback
import io.petros.github.presentation.feature.search.view.RepositoryItemView
import io.petros.github.test.domain.TestRepositoryProvider.Companion.provideRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class RepositoryViewHolderRobolectricTest {

    private val context = provideContext()

    private val repository = provideRepository()

    private val itemViewMock = mock<RepositoryItemView>()
    private val callbackMock = mock<RepositoryCallback>()

    private lateinit var testedClassWithMockedItem: RepositoryViewHolder
    private lateinit var testedClassWithoutMockedItem: RepositoryViewHolder

    @Before
    fun setUp() {
        testedClassWithMockedItem = RepositoryViewHolder(itemViewMock, callbackMock)
        testedClassWithoutMockedItem = RepositoryViewHolder(RepositoryItemView(context), callbackMock)
    }

    @Test
    fun `When the view holder binds a repository, then the item view is bind with a repository`() {
        testedClassWithMockedItem.bind(repository)

        verify(itemViewMock).bind(repository)
    }

    @Test
    fun `When the item view is clicked, then the callback's on click event is triggered`() {
        testedClassWithoutMockedItem.bind(repository)

        testedClassWithoutMockedItem.itemView.performClick()

        verify(callbackMock).onClick(repository)
    }

}
