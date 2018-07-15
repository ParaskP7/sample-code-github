package io.petros.github.presentation.feature.repository.subscriber

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyZeroInteractions
import io.petros.github.domain.model.repository.RepositoryDetails
import io.petros.github.test.domain.TestRepositoryProvider.Companion.provideRepositoryDetails
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RepositoryDetailsSubscriberTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val repositoryDetails = provideRepositoryDetails()

    private val detailsObservableMock = mock<Observer<RepositoryDetails>>()

    private lateinit var testedClass: RepositoryDetailsSubscriber

    @Before
    fun setUp() {
        testedClass = RepositoryDetailsSubscriber(MutableLiveData())
        testedClass.detailsObservable.observeForever(detailsObservableMock)
    }

    @Test
    fun `When repository details succeeds, then repository details is posted`() {
        testedClass.onSuccess(repositoryDetails)

        verify(detailsObservableMock).onChanged(repositoryDetails)
    }

    @Test
    fun `When repository details fails, then no repository details is posted`() {
        testedClass.onError(Exception())

        verifyZeroInteractions(detailsObservableMock)
    }

}
