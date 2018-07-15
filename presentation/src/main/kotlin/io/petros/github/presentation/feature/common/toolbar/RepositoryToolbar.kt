package io.petros.github.presentation.feature.common.toolbar

import android.content.Context
import android.support.design.widget.AppBarLayout
import android.util.AttributeSet
import io.petros.github.R
import io.petros.github.domain.model.search.Repository
import io.petros.github.presentation.feature.displayCircleImage
import io.petros.github.presentation.feature.inflate
import kotlinx.android.synthetic.main.toolbar_repository.view.*

class RepositoryToolbar : AppBarLayout {

    constructor(ctx: Context) : super(ctx)

    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)

    init {
        inflate(R.layout.toolbar_repository)
    }

    fun bind(repository: Repository) {
        tv_name.text = repository.name
        iv_owner_avatar.displayCircleImage(repository.ownerAvatar)
    }

    fun setOnBackClick(action: () -> Unit) = iv_back.setOnClickListener { action() }

}
