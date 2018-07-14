package io.petros.github.presentation.feature.search.subscriber

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyZeroInteractions
import io.petros.github.domain.model.search.SearchResults
import io.petros.github.test.domain.TestSearchResultsProvider.Companion.provideSearchResults
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchSubscriberTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val searchResults = provideSearchResults()

    private val searchResultsObservableMock = mock<Observer<SearchResults>>()

    private lateinit var testedClass: SearchSubscriber

    @Before
    fun setUp() {
        testedClass = SearchSubscriber(MutableLiveData())
        testedClass.searchResultsObservable.observeForever(searchResultsObservableMock)
    }

    @Test
    fun `When search succeeds, then search results is posted`() {
        testedClass.onSuccess(searchResults)

        verify(searchResultsObservableMock).onChanged(searchResults)
    }

    @Test
    fun `When search fails, then no search results is posted`() {
        testedClass.onError(Exception())

        verifyZeroInteractions(searchResultsObservableMock)
    }

}
