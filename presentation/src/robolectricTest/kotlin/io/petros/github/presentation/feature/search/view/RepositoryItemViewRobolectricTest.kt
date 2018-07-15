package io.petros.github.presentation.feature.search.view

import io.petros.github.presentation.RobolectricTestProvider.Companion.provideContext
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

    private lateinit var testedClass: RepositoryItemView

    @Before
    fun setUp() {
        testedClass = RepositoryItemView(context)
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

}
