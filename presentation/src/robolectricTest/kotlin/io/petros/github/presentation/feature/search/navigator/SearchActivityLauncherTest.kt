package io.petros.github.presentation.feature.search.navigator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.petros.github.presentation.feature.search.SearchActivity
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class SearchActivityLauncherTest {

    private var appCompatActivityMock = mock<AppCompatActivity>()

    private val intentCaptor = ArgumentCaptor.forClass(Intent::class.java)

    private lateinit var testedClass: SearchActivityLauncher

    @Before
    fun setUp() {
        testedClass = SearchActivityLauncher(appCompatActivityMock)
    }

    @Test
    fun `When launch is called, then current activity starts target search activity`() {
        testedClass.launch()

        verify(appCompatActivityMock).startActivity(intentCaptor.capture())
        assertThat(intentCaptor.value.component.className).isEqualTo(SearchActivity::class.java.name)
    }

}
