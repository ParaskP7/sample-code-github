package io.petros.github.data.repository.subscriber

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.petros.github.data.network.WebService
import io.petros.github.test.domain.TestRepositoryProvider.Companion.provideRepository
import org.junit.Before
import org.junit.Test

class SubscriberRepositoryImplTest {

    private val repository = provideRepository()

    private val webServiceMock = mock<WebService>()

    private lateinit var testedClass: SubscriberRepositoryImpl

    @Before
    fun setUp() {
        testedClass = SubscriberRepositoryImpl(webServiceMock)
    }

    @Test
    fun `When subscribers is triggered, then web service triggers subscribers`() {
        testedClass.subscribers(repository)

        verify(webServiceMock).subscribers(repository)
    }

}
