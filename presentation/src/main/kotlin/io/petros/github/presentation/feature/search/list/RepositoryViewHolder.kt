package io.petros.github.presentation.feature.search.list

import android.support.v7.widget.RecyclerView
import io.petros.github.domain.model.search.Repository
import io.petros.github.presentation.feature.search.listener.RepositoryCallback
import io.petros.github.presentation.feature.search.view.RepositoryItemView

class RepositoryViewHolder(
    itemView: RepositoryItemView,
    private val callback: RepositoryCallback
) : RecyclerView.ViewHolder(itemView) {

    fun bind(repository: Repository) {
        bindRepository(repository)
        bindRepositoryCallback(repository)
    }

    private fun bindRepository(repository: Repository) {
        (itemView as RepositoryItemView).bind(repository)
    }

    private fun bindRepositoryCallback(repository: Repository) {
        (itemView as RepositoryItemView).bindCallback(repository, callback)
    }

}
