package io.petros.github.data.repository.search

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.petros.github.data.network.WebService
import io.petros.github.test.domain.TestSearchResultsProvider.Companion.SEARCH_TERM
import org.junit.Before
import org.junit.Test

class SearchRepositoryImplTest {

    private val webServiceMock = mock<WebService>()

    private lateinit var testedClass: SearchRepositoryImpl

    @Before
    fun setUp() {
        testedClass = SearchRepositoryImpl(webServiceMock)
    }

    @Test
    fun `When search is triggered, then web service triggers search`() {
        testedClass.search(SEARCH_TERM)

        verify(webServiceMock).search(SEARCH_TERM)
    }

}
