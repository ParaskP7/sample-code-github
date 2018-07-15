package io.petros.github.presentation

import org.robolectric.shadows.ShadowApplication

class RobolectricTestProvider {

    companion object {

        internal fun provideContext() = ShadowApplication.getInstance().applicationContext!!

    }

}
