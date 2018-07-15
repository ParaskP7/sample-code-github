package io.petros.github.presentation.feature.repository

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.petros.github.domain.interactor.repository.RepositoryDetailsUseCase
import io.petros.github.domain.interactor.subscriber.SubscribersUseCase
import io.petros.github.presentation.feature.common.list.adapter.AdapterStatus
import io.petros.github.test.domain.TestRepositoryProvider.Companion.provideRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RepositoryActivityViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val repository = provideRepository()

    private val repositoryDetailsUseCaseMock = mock<RepositoryDetailsUseCase>()
    private val subscribersUseCaseMock = mock<SubscribersUseCase>()

    private val statusObservableMock = mock<Observer<AdapterStatus>>()

    private lateinit var testedClass: RepositoryActivityViewModel

    @Before
    fun setUp() {
        testedClass = RepositoryActivityViewModel(repositoryDetailsUseCaseMock, subscribersUseCaseMock)
        testedClass.statusObservable.observeForever(statusObservableMock)
    }

    /* DETAILS */

    @Test
    fun `When load is triggered, then repository details use case executes`() {
        testedClass.load(repository)

        verify(repositoryDetailsUseCaseMock).execute(any(), eq(RepositoryDetailsUseCase.Params.with(repository)))
    }

    @Test
    fun `When view model is destroyed, then repository details use case is disposed`() {
        testedClass.onCleared()

        verify(repositoryDetailsUseCaseMock).dispose()
    }

    /* SUBSCRIBERS */

    @Test
    fun `When load is triggered, then a loading status is posted`() {
        testedClass.load(repository)

        verify(statusObservableMock).onChanged(AdapterStatus.LOADING)
    }

    @Test
    fun `When load is triggered, then subscribers use case executes`() {
        testedClass.load(repository)

        verify(subscribersUseCaseMock).execute(any(), eq(SubscribersUseCase.Params.with(repository)))
    }

    @Test
    fun `When view model is destroyed, then subscribers use case is disposed`() {
        testedClass.onCleared()

        verify(subscribersUseCaseMock).dispose()
    }

}
