package io.petros.github.presentation.feature.search

import android.arch.lifecycle.Observer
import android.os.Bundle
import io.petros.github.R
import io.petros.github.presentation.feature.BaseActivity
import io.petros.github.presentation.feature.common.toolbar.SearchToolbarCallback
import io.petros.github.presentation.feature.search.list.RepositoryAdapter
import kotlinx.android.synthetic.main.activity_search.*

@Suppress("TooManyFunctions")
class SearchActivity : BaseActivity<SearchActivityViewModel>(), SearchToolbarCallback {

    private val adapter = RepositoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar()
        initRecyclerView()
        initObservers()
    }

    private fun initToolbar() {
        toolbar.searchToolbarCallback = this
    }

    private fun initRecyclerView() {
        recycler_view.adapter = adapter
    }

    /* OBSERVERS */

    private fun initObservers() {
        observeStatus()
        observeSearchResult()
    }

    private fun observeStatus() {
        viewModel.statusObservable.observe(this, Observer {
            it?.let { adapter.status = it }
        })
    }

    private fun observeSearchResult() {
        viewModel.resultsObservable.observe(this, Observer {
            it?.let { adapter.setItems(it.repositories) }
        })
    }

    /* CALLBACK */

    override fun onSearch(searchTerm: String) {
        search(searchTerm)
    }

    /* DATA LOADING */

    private fun search(searchTerm: String) {
        viewModel.search(searchTerm)
    }

    /* CONTRACT */

    override fun constructContentView() = R.layout.activity_search

    override fun constructViewModel() = SearchActivityViewModel::class.java

}
