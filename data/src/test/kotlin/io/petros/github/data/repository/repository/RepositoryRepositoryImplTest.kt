package io.petros.github.data.repository.repository

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.petros.github.data.network.WebService
import io.petros.github.test.domain.TestRepositoryProvider.Companion.provideRepository
import org.junit.Before
import org.junit.Test

class RepositoryRepositoryImplTest {

    private val repository = provideRepository()

    private val webServiceMock = mock<WebService>()

    private lateinit var testedClass: RepositoryRepositoryImpl

    @Before
    fun setUp() {
        testedClass = RepositoryRepositoryImpl(webServiceMock)
    }

    @Test
    fun `When repository details is triggered, then web service triggers repository details`() {
        testedClass.repositoryDetails(repository)

        verify(webServiceMock).repositoryDetails(repository)
    }

}
