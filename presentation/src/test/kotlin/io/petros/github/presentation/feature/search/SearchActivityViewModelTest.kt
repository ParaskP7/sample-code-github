package io.petros.github.presentation.feature.search

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.petros.github.domain.interactor.search.SearchUseCase
import io.petros.github.test.domain.TestSearchResultsProvider.Companion.SEARCH_TERM
import org.junit.Before
import org.junit.Test

class SearchActivityViewModelTest {

    private val searchUseCaseMock = mock<SearchUseCase>()

    private lateinit var testedClass: SearchActivityViewModel

    @Before
    fun setUp() {
        testedClass = SearchActivityViewModel(searchUseCaseMock)
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
