package io.petros.github.presentation.feature.repository.view

import io.petros.github.presentation.RobolectricTestProvider.Companion.provideContext
import io.petros.github.test.domain.TestSubscriberProvider.Companion.provideSubscriber
import kotlinx.android.synthetic.main.item_subscriber.view.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class SubscriberItemViewRobolectricTest {

    private val context = provideContext()

    private val subscriber = provideSubscriber()

    private lateinit var testedClass: SubscriberItemView

    @Before
    fun setUp() {
        testedClass = SubscriberItemView(context)
    }

    @Test
    fun `When subscriber is bind, then subscriber avatar is set`() {
        assertThat(testedClass.iv_subscriber_avatar.drawable).isNull()

        testedClass.bind(subscriber)

        assertThat(testedClass.iv_subscriber_avatar.drawable).isNotNull
    }

    @Test
    fun `When subscriber is bind, then subscriber login is set`() {
        testedClass.bind(subscriber)

        assertThat(testedClass.tv_subscriber_login.text).isEqualTo(subscriber.login)
    }

}
