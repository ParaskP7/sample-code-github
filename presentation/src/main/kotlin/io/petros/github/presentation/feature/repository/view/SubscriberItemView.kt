package io.petros.github.presentation.feature.repository.view

import android.content.Context
import android.support.v7.widget.CardView
import android.util.AttributeSet
import android.view.ViewGroup
import io.petros.github.R
import io.petros.github.domain.model.subscriber.Subscriber
import io.petros.github.presentation.feature.displayImage
import io.petros.github.presentation.feature.getDimension
import io.petros.github.presentation.feature.inflate
import io.petros.github.presentation.feature.setBackgroundColorCompat
import kotlinx.android.synthetic.main.item_subscriber.view.*

class SubscriberItemView : CardView {

    constructor(ctx: Context) : super(ctx)

    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)

    init {
        inflate(R.layout.item_subscriber)
        initView()
    }

    private fun initView() {
        val lp = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, context.getDimension(R.dimen.subscriber_item_height))
        lp.leftMargin = context.getDimension(R.dimen.subscriber_item_margin)
        lp.rightMargin = context.getDimension(R.dimen.subscriber_item_margin)
        lp.bottomMargin = context.getDimension(R.dimen.subscriber_item_space)
        layoutParams = lp
        radius = context.getDimension(R.dimen.subscriber_item_radius).toFloat()
        cardElevation = context.getDimension(R.dimen.subscriber_item_elevation).toFloat()
        setBackgroundColorCompat(android.R.color.white)
    }

    fun bind(subscriber: Subscriber) {
        bindRepository(subscriber)
    }

    private fun bindRepository(subscriber: Subscriber) {
        iv_subscriber_avatar.displayImage(subscriber.avatar)
        tv_subscriber_login.text = subscriber.login
    }

}
