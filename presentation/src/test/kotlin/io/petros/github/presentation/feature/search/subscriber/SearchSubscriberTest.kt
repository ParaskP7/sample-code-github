package io.petros.github.presentation.feature.search.subscriber

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyZeroInteractions
import io.petros.github.domain.model.repository.RepositoryResults
import io.petros.github.presentation.feature.common.list.adapter.AdapterStatus
import io.petros.github.test.domain.TestSearchResultsProvider.Companion.provideRepositoryResults
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchSubscriberTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val repositoryResults = provideRepositoryResults()

    private val statusObservableMock = mock<Observer<AdapterStatus>>()
    private val repositoriesObservableMock = mock<Observer<RepositoryResults>>()

    private lateinit var testedClass: SearchSubscriber

    @Before
    fun setUp() {
        testedClass = SearchSubscriber(MutableLiveData(), MutableLiveData())
        testedClass.statusObservable.observeForever(statusObservableMock)
        testedClass.repositoriesObservable.observeForever(repositoriesObservableMock)
    }

    @Test
    fun `When search succeeds, then an idle status is posted`() {
        testedClass.onSuccess(repositoryResults)

        verify(statusObservableMock).onChanged(AdapterStatus.IDLE)
    }

    @Test
    fun `When search succeeds, then repository results is posted`() {
        testedClass.onSuccess(repositoryResults)

        verify(repositoriesObservableMock).onChanged(repositoryResults)
    }

    @Test
    fun `When search fails, then an error status is posted`() {
        testedClass.onError(Exception())

        verify(statusObservableMock).onChanged(AdapterStatus.ERROR)
    }

    @Test
    fun `When search fails, then no repository results is posted`() {
        testedClass.onError(Exception())

        verifyZeroInteractions(repositoriesObservableMock)
    }

}
