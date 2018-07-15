package io.petros.github.presentation.feature

import android.support.annotation.ColorRes
import android.support.annotation.LayoutRes
import android.view.View
import android.view.ViewGroup
import io.petros.github.data.getColorCompat

fun ViewGroup.inflate(@LayoutRes resource: Int): View {
    return View.inflate(context, resource, this)
}

fun View.setBackgroundColorCompat(@ColorRes resource: Int) {
    setBackgroundColor(context.getColorCompat(resource))
}
