package io.petros.github.presentation.feature.repository

import android.arch.lifecycle.Observer
import android.os.Bundle
import com.f2prateek.dart.InjectExtra
import io.petros.github.R
import io.petros.github.domain.model.search.Repository
import io.petros.github.presentation.feature.BaseActivity
import kotlinx.android.synthetic.main.activity_repository.*
import timber.log.Timber

class RepositoryActivity : BaseActivity<RepositoryActivityViewModel>() {

    @InjectExtra lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar()
        initObservers()
        load()
    }

    private fun initToolbar() {
        toolbar.bind(repository)
        toolbar.setOnBackClick { onBackPressed() }
    }

    /* OBSERVERS */

    private fun initObservers() {
        observeDetails()
        observeStatus()
        observeSubscribers()
    }

    private fun observeDetails() {
        viewModel.detailsObservable.observe(this, Observer {
            it?.let { Timber.i("$it") }
        })
    }

    private fun observeStatus() {
        viewModel.statusObservable.observe(this, Observer {
            it?.let { Timber.i("$it") }
        })
    }

    private fun observeSubscribers() {
        viewModel.subscribersObservable.observe(this, Observer {
            it?.let { Timber.i("$it") }
        })
    }

    /* DATA LOADING */

    private fun load() {
        viewModel.load(repository)
    }

    /* CONTRACT */

    override fun constructContentView() = R.layout.activity_repository

    override fun constructViewModel() = RepositoryActivityViewModel::class.java

}
