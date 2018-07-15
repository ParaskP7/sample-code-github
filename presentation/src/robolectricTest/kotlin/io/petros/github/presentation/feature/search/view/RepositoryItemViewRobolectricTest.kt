package io.petros.github.presentation.feature.search.view

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.petros.github.presentation.RobolectricTestProvider.Companion.provideContext
import io.petros.github.presentation.feature.search.listener.RepositoryCallback
import io.petros.github.test.domain.TestRepositoryProvider.Companion.provideRepository
import kotlinx.android.synthetic.main.item_repository.view.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class RepositoryItemViewRobolectricTest {

    private val context = provideContext()

    private val repository = provideRepository()

    private val callbackMock = mock<RepositoryCallback>()

    private lateinit var testedClass: RepositoryItemView

    @Before
    fun setUp() {
        testedClass = RepositoryItemView(context)
    }

    @Test
    fun `When repository is bind, then repository owner avatar is set`() {
        assertThat(testedClass.iv_repository_owner_avatar.drawable).isNull()

        testedClass.bind(repository)

        assertThat(testedClass.iv_repository_owner_avatar.drawable).isNotNull
    }

    @Test
    fun `When repository is bind, then repository name is set`() {
        testedClass.bind(repository)

        assertThat(testedClass.tv_repository_name.text).isEqualTo(repository.name)
    }

    @Test
    fun `When repository is bind, then repository description is set`() {
        testedClass.bind(repository)

        assertThat(testedClass.tv_repository_description.text).isEqualTo(repository.description)
    }

    @Test
    fun `When repository is bind, then repository number of forks is set`() {
        testedClass.bind(repository)

        assertThat(testedClass.tv_repository_number_of_forks.text).isEqualTo(repository.numberOfForks.toString())
    }

    @Test
    fun `When repository callback is bind, then the callback's on click event is triggered`() {
        testedClass.bindCallback(repository, callbackMock)

        testedClass.performClick()

        val sharedElementRepository = SharedElementRepository(repository, testedClass.iv_repository_owner_avatar)
        verify(callbackMock).onClick(sharedElementRepository)
    }

}
