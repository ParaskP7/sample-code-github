package io.petros.github.presentation.feature.repository.subscriber

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyZeroInteractions
import io.petros.github.domain.model.subscriber.SubscriberResults
import io.petros.github.presentation.feature.common.list.adapter.AdapterStatus
import io.petros.github.test.domain.TestSubscriberProvider.Companion.provideSubscriberResults
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SubscribersSubscriberTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val subscriberResults = provideSubscriberResults()

    private val statusObservableMock = mock<Observer<AdapterStatus>>()
    private val subscriberObservableMock = mock<Observer<SubscriberResults>>()

    private lateinit var testedClass: SubscribersSubscriber

    @Before
    fun setUp() {
        testedClass = SubscribersSubscriber(MutableLiveData(), MutableLiveData())
        testedClass.statusObservable.observeForever(statusObservableMock)
        testedClass.subscribersObservable.observeForever(subscriberObservableMock)
    }

    @Test
    fun `When subscriber results succeeds, then an idle status is posted`() {
        testedClass.onSuccess(subscriberResults)

        verify(statusObservableMock).onChanged(AdapterStatus.IDLE)
    }

    @Test
    fun `When subscriber results succeeds, then subscriber results is posted`() {
        testedClass.onSuccess(subscriberResults)

        verify(subscriberObservableMock).onChanged(subscriberResults)
    }

    @Test
    fun `When subscriber results fails, then an error status is posted`() {
        testedClass.onError(Exception())

        verify(statusObservableMock).onChanged(AdapterStatus.ERROR)
    }

    @Test
    fun `When subscriber results fails, then no subscriber results is posted`() {
        testedClass.onError(Exception())

        verifyZeroInteractions(subscriberObservableMock)
    }

}
