package io.petros.github.presentation.feature

import android.support.v4.content.ContextCompat
import android.widget.ImageView
import io.petros.github.R
import io.petros.github.presentation.image.glide.GlideApp

fun ImageView.displayImage(url: String?, placeholder: Int = R.drawable.ic_hub_black) {
    if (url != null) {
        GlideApp.with(this)
            .load(url)
            .placeholder(placeholder)
            .fitCenter()
            .into(this)
    } else {
        setImageDrawable(ContextCompat.getDrawable(context, placeholder))
    }
}

fun ImageView.displayCircleImage(url: String?, placeholder: Int = R.drawable.ic_hub_white) {
    if (url != null) {
        GlideApp.with(this)
            .load(url)
            .placeholder(placeholder)
            .circleCrop()
            .into(this)
    } else {
        setImageDrawable(ContextCompat.getDrawable(context, placeholder))
    }
}
