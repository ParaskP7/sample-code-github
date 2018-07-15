package io.petros.github.presentation.feature.search

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.petros.github.domain.interactor.search.SearchUseCase
import io.petros.github.presentation.feature.common.list.adapter.AdapterStatus
import io.petros.github.test.domain.TestSearchResultsProvider.Companion.SEARCH_TERM
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchActivityViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val searchUseCaseMock = mock<SearchUseCase>()

    private val statusObservableMock = mock<Observer<AdapterStatus>>()

    private lateinit var testedClass: SearchActivityViewModel

    @Before
    fun setUp() {
        testedClass = SearchActivityViewModel(searchUseCaseMock)
        testedClass.statusObservable.observeForever(statusObservableMock)
    }

    @Test
    fun `When search is triggered, then a loading status is posted`() {
        testedClass.search(SEARCH_TERM)

        verify(statusObservableMock).onChanged(AdapterStatus.LOADING)
    }

    @Test
    fun `When search is triggered, then search use case executes`() {
        testedClass.search(SEARCH_TERM)

        verify(searchUseCaseMock).execute(any(), eq(SearchUseCase.Params.with(SEARCH_TERM)))
    }

    @Test
    fun `When view model is destroyed, then search use case is disposed`() {
        testedClass.onCleared()

        verify(searchUseCaseMock).dispose()
    }

}
