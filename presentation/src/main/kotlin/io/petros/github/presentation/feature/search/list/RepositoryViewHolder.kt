package io.petros.github.presentation.feature.search.list

import android.support.v7.widget.RecyclerView
import io.petros.github.domain.model.search.Repository
import io.petros.github.presentation.feature.search.view.RepositoryItemView

class RepositoryViewHolder(
    itemView: RepositoryItemView
) : RecyclerView.ViewHolder(itemView) {

    fun bind(repository: Repository) {
        bindRepository(repository)
    }

    private fun bindRepository(repository: Repository) {
        (itemView as RepositoryItemView).bind(repository)
    }

}
