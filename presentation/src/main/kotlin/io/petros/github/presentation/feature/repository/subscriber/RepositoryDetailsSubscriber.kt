package io.petros.github.presentation.feature.repository.subscriber

import android.arch.lifecycle.MutableLiveData
import io.petros.github.domain.model.repository.RepositoryDetails
import io.reactivex.observers.DisposableSingleObserver
import timber.log.Timber

class RepositoryDetailsSubscriber(
    val detailsObservable: MutableLiveData<RepositoryDetails>
) : DisposableSingleObserver<RepositoryDetails>() {

    override fun onSuccess(repositoryDetails: RepositoryDetails) {
        Timber.d("Load repository details success. [Repository Details: $repositoryDetails]")
        detailsObservable.postValue(repositoryDetails)
    }

    override fun onError(exception: Throwable) {
        Timber.w(exception, "Load repository details error.")
    }

}
