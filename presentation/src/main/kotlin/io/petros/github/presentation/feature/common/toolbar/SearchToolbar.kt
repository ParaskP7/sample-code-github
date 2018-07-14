package io.petros.github.presentation.feature.common.toolbar

import android.content.Context
import android.support.design.widget.AppBarLayout
import android.util.AttributeSet
import android.view.inputmethod.EditorInfo
import io.petros.github.R
import io.petros.github.presentation.feature.inflate
import kotlinx.android.synthetic.main.toolbar_search.view.*

class SearchToolbar : AppBarLayout {

    constructor(ctx: Context) : super(ctx)

    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)

    lateinit var searchToolbarCallback: SearchToolbarCallback

    init {
        inflate(R.layout.toolbar_search)
        initEditText()
    }

    private fun initEditText() {
        et_search.setOnEditorActionListener { _, actionId, _ ->
            if (searchConditions(actionId)) search(et_search.text.toString()) else false
        }
    }

    private fun searchConditions(actionId: Int) = actionId == EditorInfo.IME_ACTION_SEARCH && !et_search.text.isEmpty()

    private fun search(searchTerm: String): Boolean {
        searchToolbarCallback.onSearch(searchTerm)
        return false
    }

}
