package io.petros.github.presentation.feature.repository.list

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.petros.github.presentation.feature.repository.view.SubscriberItemView
import io.petros.github.test.domain.TestSubscriberProvider.Companion.provideSubscriber
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class SubscriberViewHolderRobolectricTest {

    private val subscriber = provideSubscriber()

    private val itemViewMock = mock<SubscriberItemView>()

    private lateinit var testedClass: SubscriberViewHolder

    @Before
    fun setUp() {
        testedClass = SubscriberViewHolder(itemViewMock)
    }

    @Test
    fun `When the view holder binds a subscriber, then the item view is bind with a subscriber`() {
        testedClass.bind(subscriber)

        verify(itemViewMock).bind(subscriber)
    }

}
