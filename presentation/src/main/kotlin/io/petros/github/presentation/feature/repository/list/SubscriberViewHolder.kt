package io.petros.github.presentation.feature.repository.list

import android.support.v7.widget.RecyclerView
import io.petros.github.domain.model.subscriber.Subscriber
import io.petros.github.presentation.feature.repository.view.SubscriberItemView

class SubscriberViewHolder(
    itemView: SubscriberItemView
) : RecyclerView.ViewHolder(itemView) {

    fun bind(subscriber: Subscriber) {
        bindSubscriber(subscriber)
    }

    private fun bindSubscriber(subscriber: Subscriber) {
        (itemView as SubscriberItemView).bind(subscriber)
    }

}
