package io.petros.github.presentation.feature.repository

import android.arch.lifecycle.Observer
import android.os.Bundle
import com.f2prateek.dart.InjectExtra
import io.petros.github.R
import io.petros.github.domain.model.repository.Repository
import io.petros.github.presentation.feature.BaseActivity
import io.petros.github.presentation.feature.repository.list.SubscriberAdapter
import kotlinx.android.synthetic.main.activity_repository.*

@Suppress("TooManyFunctions")
class RepositoryActivity : BaseActivity<RepositoryActivityViewModel>() {

    @InjectExtra lateinit var repository: Repository

    private val adapter = SubscriberAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar()
        initRecyclerView()
        initObservers()
        load()
    }

    private fun initToolbar() {
        toolbar.bind(repository)
        toolbar.setOnBackClick { onBackPressed() }
    }

    private fun initRecyclerView() {
        recycler_view.adapter = adapter
    }

    /* OBSERVERS */

    private fun initObservers() {
        observeDetails()
        observeStatus()
        observeSubscribers()
    }

    private fun observeDetails() {
        viewModel.detailsObservable.observe(this, Observer {
            it?.let { toolbar.bind(it) }
        })
    }

    private fun observeStatus() {
        viewModel.statusObservable.observe(this, Observer {
            it?.let { adapter.status = it }
        })
    }

    private fun observeSubscribers() {
        viewModel.subscribersObservable.observe(this, Observer {
            it?.let { adapter.setItems(it.subscribers) }
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
