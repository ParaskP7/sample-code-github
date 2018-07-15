package io.petros.github.presentation.feature.repository.navigator

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import io.petros.github.Henson
import io.petros.github.R
import io.petros.github.domain.model.search.Repository
import io.petros.github.presentation.feature.navigator.ActivityLauncher
import io.petros.github.presentation.feature.search.view.SharedElementRepository
import javax.inject.Inject

class RepositoryActivityLauncher @Inject constructor(
    private val activity: AppCompatActivity
) : ActivityLauncher(activity), RepositoryLauncher {

    override fun launch(repository: Repository) {
        activity.startActivity(getIntent(repository))
    }

    override fun launch(repository: SharedElementRepository) {
        activity.startActivity(getIntent(repository.repository), getSharedElement(repository))
    }

    private fun getIntent(repository: Repository): Intent {
        return Henson.with(activity)
            .gotoRepositoryActivity()
            .repository(repository)
            .build()
    }

    private fun getSharedElement(repository: SharedElementRepository): Bundle? {
        val sharedElement = activity.getString(R.string.owner_avatar_shared_element)
        val anim = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, repository.sharedElement, sharedElement)
        return anim.toBundle()
    }

}
