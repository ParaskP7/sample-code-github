package io.petros.github.data.network.rest

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.petros.github.test.domain.TestRepositoryProvider.Companion.provideRepository
import io.petros.github.test.domain.TestSearchResultsProvider.Companion.SEARCH_TERM
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class RestClientTest {

    private val repository = provideRepository()

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

    @Test
    fun `When a repository details is triggered, then api repository details is triggered`() {
        whenever(restApiMock.repositoryDetails(repository.login, repository.name)).thenReturn(Single.just(mock()))

        testedClass.repositoryDetails(repository)

        verify(restApiMock).repositoryDetails(repository.login, repository.name)
    }

    @Test
    fun `When a subscribers is triggered, then api subscribers is triggered`() {
        whenever(restApiMock.subscribers(repository.login, repository.name)).thenReturn(Single.just(arrayOf(mock())))

        testedClass.subscribers(repository)

        verify(restApiMock).subscribers(repository.login, repository.name)
    }

}
