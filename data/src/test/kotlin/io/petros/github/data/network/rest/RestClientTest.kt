package io.petros.github.data.network.rest

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.petros.github.test.domain.TestSearchResultsProvider.Companion.SEARCH_TERM
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class RestClientTest {

    private val restApiMock = mock<RestApi>()

    private lateinit var testedClass: RestClient

    @Before
    fun setUp() {
        testedClass = RestClient(restApiMock)
    }

    @Test
    fun `When a search is triggered, then api search is triggered`() {
        whenever(restApiMock.search(SEARCH_TERM)).thenReturn(Single.just(mock()))

        testedClass.search(SEARCH_TERM)

        verify(restApiMock).search(SEARCH_TERM)
    }

}
