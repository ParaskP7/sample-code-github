package io.petros.github.presentation.feature.repository.navigator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.petros.github.presentation.feature.repository.RepositoryActivity
import io.petros.github.test.domain.TestRepositoryProvider
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class RepositoryActivityLauncherRobolectricTest {

    private val repository = TestRepositoryProvider.provideRepository()

    private var appCompatActivityMock = mock<AppCompatActivity>()

    private val intentCaptor = ArgumentCaptor.forClass(Intent::class.java)

    private lateinit var testedClass: RepositoryActivityLauncher

    @Before
    fun setUp() {
        testedClass = RepositoryActivityLauncher(appCompatActivityMock)
    }

    @Test
    fun `When launch is called, then current activity starts target repository activity`() {
        testedClass.launch(repository)

        verify(appCompatActivityMock).startActivity(intentCaptor.capture())
        assertThat(intentCaptor.value.component.className).isEqualTo(RepositoryActivity::class.java.name)
    }

}
