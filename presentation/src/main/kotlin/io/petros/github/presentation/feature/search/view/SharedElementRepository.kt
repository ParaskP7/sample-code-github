package io.petros.github.presentation.feature.search.view

import android.view.View
import io.petros.github.domain.model.repository.Repository

data class SharedElementRepository(
    val repository: Repository,
    val sharedElement: View
)
