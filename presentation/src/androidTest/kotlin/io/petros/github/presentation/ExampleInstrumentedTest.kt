package io.petros.github.presentation

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun useAppContext() {
        assertEquals("io.petros.github.debug", InstrumentationRegistry.getTargetContext().packageName)
    }

}
