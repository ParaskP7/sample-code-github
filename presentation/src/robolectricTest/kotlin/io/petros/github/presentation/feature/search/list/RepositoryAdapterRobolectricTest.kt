package io.petros.github.presentation.feature.search.list

import android.support.v7.widget.RecyclerView
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyZeroInteractions
import io.petros.github.domain.model.repository.Repository
import io.petros.github.presentation.RobolectricTestProvider.Companion.provideContext
import io.petros.github.presentation.feature.common.list.adapter.AdapterStatus
import io.petros.github.presentation.feature.common.list.holder.ErrorViewHolder
import io.petros.github.presentation.feature.common.list.holder.ProgressViewHolder
import io.petros.github.presentation.feature.search.list.RepositoryAdapter.Companion.VIEW_TYPE_ERROR
import io.petros.github.presentation.feature.search.list.RepositoryAdapter.Companion.VIEW_TYPE_PROGRESS
import io.petros.github.presentation.feature.search.list.RepositoryAdapter.Companion.VIEW_TYPE_REPOSITORY
import io.petros.github.test.domain.TestRepositoryProvider.Companion.provideRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class RepositoryAdapterRobolectricTest {

    private val context = provideContext()
    private val recyclerView = RecyclerView(context)

    private val allItems = ArrayList<Repository>()
    private val currentItems = listOf(provideRepository(id = 1), provideRepository(id = 2), provideRepository(id = 3))
    private val newItems = listOf(provideRepository(id = 4), provideRepository(id = 5), provideRepository(id = 6))

    private lateinit var testedClass: RepositoryAdapter

    @Before
    fun setUp() {
        allItems.addAll(currentItems)

        testedClass = RepositoryAdapter(allItems)
        testedClass.callback = mock()
    }

    /* CONTEXT */

    @Test
    fun `When adapter is set, then status is idle`() {
        assertThat(testedClass.status).isEqualTo(AdapterStatus.IDLE)
    }

    @Test
    fun `When attaching to recycler view, then context is set`() {
        assertThat(testedClass.context).isNull()

        testedClass.onAttachedToRecyclerView(recyclerView)

        assertThat(testedClass.context).isEqualTo(context)
    }

    @Test
    fun `When detaching from recycler view, then context is unset`() {
        testedClass.onAttachedToRecyclerView(recyclerView)
        assertThat(testedClass.context).isEqualTo(context)

        testedClass.onDetachedFromRecyclerView(recyclerView)

        assertThat(testedClass.context).isNull()
    }

    /* ITEMS */

    @Test
    fun `When adapter is set, then all items are used`() {
        assertThat(testedClass.itemCount).isEqualTo(currentItems.size)
    }

    @Test
    fun `When setting items to adapter, then new items replace the current items`() {
        assertThat(testedClass.items).isEqualTo(currentItems)

        testedClass.setItems(newItems)

        assertThat(testedClass.items).isEqualTo(newItems)
    }

    /* VIEW HOLDER */

    @Test
    fun `When creating a view holder for a repository item, then the correct view holder is returned`() {
        testedClass.onAttachedToRecyclerView(recyclerView)

        val viewHolder = testedClass.onCreateViewHolder(mock(), VIEW_TYPE_REPOSITORY)

        assertThat(viewHolder).isInstanceOf(RepositoryViewHolder::class.java)
    }

    @Test
    fun `When creating a view holder for a progress item, then the correct view holder is returned`() {
        testedClass.onAttachedToRecyclerView(recyclerView)

        val viewHolder = testedClass.onCreateViewHolder(mock(), VIEW_TYPE_PROGRESS)

        assertThat(viewHolder).isInstanceOf(ProgressViewHolder::class.java)
    }

    @Test
    fun `When creating a view holder for an error item, then the correct view holder is returned`() {
        testedClass.onAttachedToRecyclerView(recyclerView)

        val viewHolder = testedClass.onCreateViewHolder(mock(), VIEW_TYPE_ERROR)

        assertThat(viewHolder).isInstanceOf(ErrorViewHolder::class.java)
    }

    @Test
    fun `Given a repository view type, when binding a view holder, then a repository item is bind`() {
        testedClass.onAttachedToRecyclerView(recyclerView)
        testedClass.onCreateViewHolder(mock(), VIEW_TYPE_REPOSITORY)
        val position = 1
        val viewHolderMock = mock<RepositoryViewHolder>()

        testedClass.onBindViewHolder(viewHolderMock, position)

        verify(viewHolderMock).bind(currentItems[position])
    }

    @Test
    fun `Given a non repository view type, when binding a view holder, then a repository item is not bind`() {
        testedClass.onAttachedToRecyclerView(recyclerView)
        testedClass.onCreateViewHolder(mock(), VIEW_TYPE_PROGRESS)
        testedClass.status = AdapterStatus.LOADING
        val position = currentItems.size
        val viewHolderMock = mock<RepositoryViewHolder>()

        testedClass.onBindViewHolder(viewHolderMock, position)

        verifyZeroInteractions(viewHolderMock)
    }

    /* NAVIGATION */

    @Test
    fun `When getting the item view type of a repository item, then a repository view type is returned`() {
        val result = testedClass.getItemViewType(1)

        assertThat(result).isEqualTo(VIEW_TYPE_REPOSITORY)
    }

    @Test
    fun `Given at last position and idle, when getting the item view type, then a repository item view type is returned`() {
        testedClass.status = AdapterStatus.IDLE

        val result = testedClass.getItemViewType(currentItems.size)

        assertThat(result).isEqualTo(VIEW_TYPE_REPOSITORY)
    }

    @Test
    fun `Given at last position and loading, when getting the item view type, then a progress view type is returned`() {
        testedClass.status = AdapterStatus.LOADING

        val result = testedClass.getItemViewType(currentItems.size)

        assertThat(result).isEqualTo(VIEW_TYPE_PROGRESS)
    }

    @Test
    fun `Given at last position and error, when getting the item view type, then an error view type is returned`() {
        testedClass.status = AdapterStatus.ERROR

        val result = testedClass.getItemViewType(currentItems.size)

        assertThat(result).isEqualTo(VIEW_TYPE_ERROR)
    }

}
