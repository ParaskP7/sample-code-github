package io.petros.github.domain.interactor.subscriber

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.petros.github.domain.repository.subsriber.SubscriberRepository
import io.petros.github.test.domain.TestRepositoryProvider.Companion.provideRepository
import io.petros.github.test.domain.TestSubscriberProvider.Companion.provideSubscriberResults
import io.petros.github.test.rx.TestRxProvider.Companion.provideRxSchedulers
import io.reactivex.Single
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class SubscribersUseCaseTest {

    private val repository = provideRepository()
    private val subscriberResults = provideSubscriberResults()

    private val subscriberRepositoryMock = mock<SubscriberRepository>()

    private lateinit var testedClass: SubscribersUseCase
    private val params = SubscribersUseCase.Params.with(repository)

    @Before
    fun setUp() {
        testedClass = SubscribersUseCase(subscriberRepositoryMock, provideRxSchedulers())
    }

    @Test
    fun `When subscriber use case is build, then subscriber repository triggers subscribers`() {
        testedClass.buildUseCaseObservable(params)

        verify(subscriberRepositoryMock).subscribers(repository)
    }

    @Test
    fun `When subscribers returns, then subscriber results is the expected one`() {
        whenever(subscriberRepositoryMock.subscribers(repository)).thenReturn(Single.just(subscriberResults))

        val result = testedClass.buildUseCaseObservable(params).blockingGet()

        assertThat(result).isEqualTo(subscriberResults)
    }

}
