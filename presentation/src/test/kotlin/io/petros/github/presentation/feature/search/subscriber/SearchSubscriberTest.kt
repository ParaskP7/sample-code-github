package io.petros.github.presentation.feature.search.subscriber

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyZeroInteractions
import io.petros.github.domain.model.search.SearchResults
import io.petros.github.presentation.feature.common.list.adapter.AdapterStatus
import io.petros.github.test.domain.TestSearchResultsProvider.Companion.provideSearchResults
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchSubscriberTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val searchResults = provideSearchResults()

    private val statusObservableMock = mock<Observer<AdapterStatus>>()
    private val resultsObservableMock = mock<Observer<SearchResults>>()

    private lateinit var testedClass: SearchSubscriber

    @Before
    fun setUp() {
        testedClass = SearchSubscriber(MutableLiveData(), MutableLiveData())
        testedClass.statusObservable.observeForever(statusObservableMock)
        testedClass.resultsObservable.observeForever(resultsObservableMock)
    }

    @Test
    fun `When search succeeds, then an idle status is posted`() {
        testedClass.onSuccess(searchResults)

        verify(statusObservableMock).onChanged(AdapterStatus.IDLE)
    }

    @Test
    fun `When search succeeds, then search results is posted`() {
        testedClass.onSuccess(searchResults)

        verify(resultsObservableMock).onChanged(searchResults)
    }

    @Test
    fun `When search fails, then an error status is posted`() {
        testedClass.onError(Exception())

        verify(statusObservableMock).onChanged(AdapterStatus.ERROR)
    }

    @Test
    fun `When search fails, then no search results is posted`() {
        testedClass.onError(Exception())

        verifyZeroInteractions(resultsObservableMock)
    }

}
