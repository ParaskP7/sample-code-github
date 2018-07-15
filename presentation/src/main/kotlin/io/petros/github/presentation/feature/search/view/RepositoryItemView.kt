package io.petros.github.presentation.feature.search.view

import android.content.Context
import android.support.v7.widget.CardView
import android.util.AttributeSet
import android.view.ViewGroup
import io.petros.github.R
import io.petros.github.domain.model.repository.Repository
import io.petros.github.presentation.feature.displayImage
import io.petros.github.presentation.feature.getDimension
import io.petros.github.presentation.feature.inflate
import io.petros.github.presentation.feature.search.listener.RepositoryCallback
import io.petros.github.presentation.feature.setBackgroundColorCompat
import kotlinx.android.synthetic.main.item_repository.view.*

class RepositoryItemView : CardView {

    constructor(ctx: Context) : super(ctx)

    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)

    init {
        inflate(R.layout.item_repository)
        initView()
    }

    private fun initView() {
        val lp = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, context.getDimension(R.dimen.repository_item_height))
        lp.leftMargin = context.getDimension(R.dimen.repository_item_margin)
        lp.rightMargin = context.getDimension(R.dimen.repository_item_margin)
        lp.bottomMargin = context.getDimension(R.dimen.repository_item_space)
        layoutParams = lp
        radius = context.getDimension(R.dimen.repository_item_radius).toFloat()
        cardElevation = context.getDimension(R.dimen.repository_item_elevation).toFloat()
        setBackgroundColorCompat(android.R.color.white)
    }

    fun bind(repository: Repository) {
        bindRepository(repository)
    }

    private fun bindRepository(repository: Repository) {
        iv_repository_owner_avatar.displayImage(repository.ownerAvatar)
        tv_repository_name.text = repository.name
        tv_repository_description.text = repository.description
        tv_repository_number_of_forks.text = repository.numberOfForks.toString()
    }

    fun bindCallback(repository: Repository, callback: RepositoryCallback) {
        val sharedElementRepository = SharedElementRepository(repository, iv_repository_owner_avatar)
        setOnClickListener { callback.onClick(sharedElementRepository) }
    }

}
