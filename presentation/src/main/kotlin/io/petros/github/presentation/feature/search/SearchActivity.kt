package io.petros.github.presentation.feature.search

import android.arch.lifecycle.Observer
import android.os.Bundle
import io.petros.github.R
import io.petros.github.domain.model.search.SearchResults
import io.petros.github.presentation.feature.BaseActivity
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : BaseActivity<SearchActivityViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initObservers()
        search()
    }

    /* OBSERVERS */

    private fun initObservers() {
        observeSearchResult()
    }

    private fun observeSearchResult() {
        viewModel.searchResultsObservable.observe(this, Observer {
            it?.let { showSearchResults(it) }
        })
    }

    private fun showSearchResults(searchResults: SearchResults) {
        tv_search_result.text = searchResults.text
    }

    /* DATA LOADING */

    private fun search() {
        viewModel.search()
    }

    /* CONTRACT */

    override fun constructContentView() = R.layout.activity_search

    override fun constructViewModel() = SearchActivityViewModel::class.java

}
