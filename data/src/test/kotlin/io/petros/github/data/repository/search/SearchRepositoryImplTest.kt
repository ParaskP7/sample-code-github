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
    fun `When search repositories is triggered, then web service triggers search repositories`() {
        testedClass.searchRepositories(SEARCH_TERM)

        verify(webServiceMock).searchRepositories(SEARCH_TERM)
    }

}
