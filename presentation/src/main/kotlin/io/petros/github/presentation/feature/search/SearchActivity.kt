package io.petros.github.presentation.feature.search

import android.arch.lifecycle.Observer
import android.os.Bundle
import io.petros.github.R
import io.petros.github.presentation.feature.BaseActivity
import io.petros.github.presentation.feature.common.toolbar.SearchToolbarCallback
import io.petros.github.presentation.feature.search.list.RepositoryAdapter
import io.petros.github.presentation.feature.search.listener.RepositoryCallback
import io.petros.github.presentation.feature.search.navigator.SearchNavigator
import io.petros.github.presentation.feature.search.view.SharedElementRepository
import kotlinx.android.synthetic.main.activity_search.*
import javax.inject.Inject

@Suppress("TooManyFunctions")
class SearchActivity : BaseActivity<SearchActivityViewModel>(), SearchToolbarCallback, RepositoryCallback {

    @Inject lateinit var searchNavigator: SearchNavigator

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
        adapter.callback = this
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

    /* NAVIGATION */

    override fun onClick(repository: SharedElementRepository) {
        searchNavigator.navigate(repository)
    }

    /* CONTRACT */

    override fun constructContentView() = R.layout.activity_search

    override fun constructViewModel() = SearchActivityViewModel::class.java

}
