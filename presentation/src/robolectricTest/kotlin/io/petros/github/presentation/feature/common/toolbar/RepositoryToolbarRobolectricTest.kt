package io.petros.github.presentation.feature.common.toolbar

import com.nhaarman.mockito_kotlin.spy
import com.nhaarman.mockito_kotlin.verify
import io.petros.github.presentation.RobolectricTestProvider.Companion.provideActivity
import io.petros.github.test.domain.TestRepositoryProvider.Companion.provideRepository
import kotlinx.android.synthetic.main.toolbar_repository.view.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class RepositoryToolbarRobolectricTest {

    private val activity = provideActivity()

    private val repository = provideRepository()

    private lateinit var testedClass: RepositoryToolbar

    @Before
    fun setUp() {
        testedClass = RepositoryToolbar(activity)
    }

    @Test
    fun `When repository is bind, then name is set`() {
        testedClass.bind(repository)

        assertThat(testedClass.tv_name.text).isEqualTo(repository.name)
    }

    @Test
    fun `When repository is bind, then owner avatar is set`() {
        assertThat(testedClass.iv_owner_avatar.drawable).isNull()

        testedClass.bind(repository)

        assertThat(testedClass.iv_owner_avatar.drawable).isNotNull
    }

    @Test
    fun `When back is clicked, then the back action is triggered`() {
        val actionSpy = spy({})
        testedClass.setOnBackClick { actionSpy() }

        testedClass.iv_back.performClick()

        verify(actionSpy).invoke()
    }

}
