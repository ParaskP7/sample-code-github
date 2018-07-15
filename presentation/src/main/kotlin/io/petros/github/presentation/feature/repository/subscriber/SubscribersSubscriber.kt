package io.petros.github.presentation.feature.repository.subscriber

import android.arch.lifecycle.MutableLiveData
import io.petros.github.domain.model.subscriber.SubscriberResults
import io.petros.github.presentation.feature.common.list.adapter.AdapterStatus
import io.reactivex.observers.DisposableSingleObserver
import timber.log.Timber

class SubscribersSubscriber(
    val statusObservable: MutableLiveData<AdapterStatus>,
    val subscribersObservable: MutableLiveData<SubscriberResults>
) : DisposableSingleObserver<SubscriberResults>() {

    override fun onSuccess(subscriberResults: SubscriberResults) {
        Timber.d("Load subscribers success. [Subscriber Results: $subscriberResults]")
        statusObservable.postValue(AdapterStatus.IDLE)
        subscribersObservable.postValue(subscriberResults)
    }

    override fun onError(exception: Throwable) {
        Timber.w(exception, "Load subscribers error.")
        statusObservable.postValue(AdapterStatus.ERROR)
    }

}
