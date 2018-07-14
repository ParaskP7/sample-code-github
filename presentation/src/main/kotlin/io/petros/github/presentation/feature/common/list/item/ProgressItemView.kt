package io.petros.github.presentation.feature.common.list.item

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import io.petros.github.R
import io.petros.github.presentation.feature.inflate

class ProgressItemView : FrameLayout {

    constructor(ctx: Context) : super(ctx)

    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)

    init {
        inflate(R.layout.item_progress)
        initView()
    }

    private fun initView() {
        layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

}
