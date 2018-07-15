package io.petros.github.presentation.feature.repository.navigator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import io.petros.github.Henson
import io.petros.github.domain.model.search.Repository
import io.petros.github.presentation.feature.navigator.ActivityLauncher
import javax.inject.Inject

class RepositoryActivityLauncher @Inject constructor(
    private val activity: AppCompatActivity
) : ActivityLauncher(activity), RepositoryLauncher {

    override fun launch(repository: Repository) {
        activity.startActivity(getIntent(repository))
    }

    private fun getIntent(repository: Repository): Intent {
        return Henson.with(activity)
            .gotoRepositoryActivity()
            .repository(repository)
            .build()
    }

}
