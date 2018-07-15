package io.petros.github.domain.interactor.search

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.petros.github.domain.repository.search.SearchRepository
import io.petros.github.test.domain.TestSearchResultsProvider.Companion.SEARCH_TERM
import io.petros.github.test.domain.TestSearchResultsProvider.Companion.provideRepositoryResults
import io.petros.github.test.rx.TestRxProvider.Companion.provideRxSchedulers
import io.reactivex.Single
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class SearchUseCaseTest {

    private val repositoryResults = provideRepositoryResults()

    private val searchRepositoryMock = mock<SearchRepository>()

    private lateinit var testedClass: SearchUseCase
    private val params = SearchUseCase.Params.with(SEARCH_TERM)

    @Before
    fun setUp() {
        testedClass = SearchUseCase(searchRepositoryMock, provideRxSchedulers())
    }

    @Test
    fun `When search use case is build, then search repository triggers search`() {
        testedClass.buildUseCaseObservable(params)

        verify(searchRepositoryMock).search(SEARCH_TERM)
    }

    @Test
    fun `When search returns, then repository results is the expected one`() {
        whenever(searchRepositoryMock.search(SEARCH_TERM)).thenReturn(Single.just(repositoryResults))

        val result = testedClass.buildUseCaseObservable(params).blockingGet()

        assertThat(result).isEqualTo(repositoryResults)
    }

}
