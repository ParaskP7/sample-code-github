package io.petros.github.presentation.feature.repository

import io.petros.github.R
import io.petros.github.presentation.feature.BaseActivity

class RepositoryActivity : BaseActivity<RepositoryActivityViewModel>() {

    /* CONTRACT */

    override fun constructContentView() = R.layout.activity_repository

    override fun constructViewModel() = RepositoryActivityViewModel::class.java

}
