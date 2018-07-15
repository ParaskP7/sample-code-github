package io.petros.github.domain.interactor.repository

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.petros.github.domain.repository.repository.RepositoryRepository
import io.petros.github.test.domain.TestRepositoryProvider.Companion.provideRepository
import io.petros.github.test.domain.TestRepositoryProvider.Companion.provideRepositoryDetails
import io.petros.github.test.rx.TestRxProvider.Companion.provideRxSchedulers
import io.reactivex.Single
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class RepositoryDetailsUseCaseTest {

    private val repository = provideRepository()
    private val repositoryDetails = provideRepositoryDetails()

    private val repositoryRepositoryMock = mock<RepositoryRepository>()

    private lateinit var testedClass: RepositoryDetailsUseCase
    private val params = RepositoryDetailsUseCase.Params.with(repository)

    @Before
    fun setUp() {
        testedClass = RepositoryDetailsUseCase(repositoryRepositoryMock, provideRxSchedulers())
    }

    @Test
    fun `When repository details use case is build, then repository repository triggers repository details`() {
        testedClass.buildUseCaseObservable(params)

        verify(repositoryRepositoryMock).repositoryDetails(repository)
    }

    @Test
    fun `When repository details returns, then repository details results is the expected one`() {
        whenever(repositoryRepositoryMock.repositoryDetails(repository)).thenReturn(Single.just(repositoryDetails))

        val result = testedClass.buildUseCaseObservable(params).blockingGet()

        assertThat(result).isEqualTo(repositoryDetails)
    }

}
