package io.petros.github.presentation.feature.search.list

import android.content.Context
import android.support.annotation.VisibleForTesting
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import io.petros.github.R
import io.petros.github.domain.model.repository.Repository
import io.petros.github.presentation.feature.common.list.adapter.AdapterStatus
import io.petros.github.presentation.feature.common.list.holder.ErrorViewHolder
import io.petros.github.presentation.feature.common.list.holder.ProgressViewHolder
import io.petros.github.presentation.feature.common.list.item.ErrorItemView
import io.petros.github.presentation.feature.common.list.item.ProgressItemView
import io.petros.github.presentation.feature.search.listener.RepositoryCallback
import io.petros.github.presentation.feature.search.view.RepositoryItemView
import io.petros.github.presentation.feature.toast

class RepositoryAdapter(
    val items: ArrayList<Repository> = arrayListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        internal const val VIEW_TYPE_PROGRESS = 0
        internal const val VIEW_TYPE_REPOSITORY = 1
        internal const val VIEW_TYPE_ERROR = 101
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    var context: Context? = null

    var status = AdapterStatus.IDLE
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    lateinit var callback: RepositoryCallback

    /* CONTEXT */

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        context = recyclerView.context
        super.onAttachedToRecyclerView(recyclerView)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        context = null
        super.onDetachedFromRecyclerView(recyclerView)
    }

    /* ITEMS */

    fun setItems(newItems: List<Repository>) {
        items.clear()
        items.plusAssign(newItems)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        val statusCount = if (status != AdapterStatus.IDLE) 1 else 0
        return items.size + statusCount
    }

    /* ITEM VIEW HOLDER */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context?.let {
            return when (viewType) {
                VIEW_TYPE_PROGRESS -> ProgressViewHolder(ProgressItemView(it))
                VIEW_TYPE_REPOSITORY -> RepositoryViewHolder(RepositoryItemView(it), callback)
                VIEW_TYPE_ERROR -> ErrorViewHolder(ErrorItemView(it)) { it.toast(R.string.retry_loading) }
                else -> throw IllegalArgumentException("View type out of range. [View Type: $viewType]")
            }
        }
        throw IllegalArgumentException("Context not initialised.")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == VIEW_TYPE_REPOSITORY) {
            (holder as RepositoryViewHolder).bind(items[position])
        }
    }

    /* NAVIGATION */

    override fun getItemViewType(position: Int): Int {
        return when {
            isAtLastPosition(position) -> when (status) {
                AdapterStatus.IDLE -> VIEW_TYPE_REPOSITORY
                AdapterStatus.LOADING -> VIEW_TYPE_PROGRESS
                AdapterStatus.ERROR -> VIEW_TYPE_ERROR
            }
            else -> VIEW_TYPE_REPOSITORY
        }
    }

    private fun isAtLastPosition(position: Int) = position == Math.max(itemCount - 1, 0)

}
