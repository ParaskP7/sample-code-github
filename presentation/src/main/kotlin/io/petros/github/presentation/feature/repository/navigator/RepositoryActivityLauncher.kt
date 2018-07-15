package io.petros.github.presentation.feature.repository.navigator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import io.petros.github.domain.model.search.Repository
import io.petros.github.presentation.feature.navigator.ActivityLauncher
import io.petros.github.presentation.feature.repository.RepositoryActivity
import javax.inject.Inject

class RepositoryActivityLauncher @Inject constructor(
    private val activity: AppCompatActivity
) : ActivityLauncher(activity), RepositoryLauncher {

    override fun launch(repository: Repository) {
        activity.startActivity(Intent(activity, RepositoryActivity::class.java))
    }

}
