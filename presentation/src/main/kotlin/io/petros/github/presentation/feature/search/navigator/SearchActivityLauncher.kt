package io.petros.github.presentation.feature.search.navigator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import io.petros.github.presentation.feature.navigator.ActivityLauncher
import io.petros.github.presentation.feature.search.SearchActivity
import javax.inject.Inject

class SearchActivityLauncher @Inject constructor(
    private val activity: AppCompatActivity
) : ActivityLauncher(activity), SearchLauncher {

    override fun launch() {
        activity.startActivity(Intent(activity, SearchActivity::class.java))
    }

}
