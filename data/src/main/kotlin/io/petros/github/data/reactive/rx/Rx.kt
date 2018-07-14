package io.petros.github.data.reactive.rx

import io.petros.github.domain.reactive.rx.RxSchedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object Rx {

    fun defaultSchedulers(): RxSchedulers = RxSchedulers(Schedulers.io(), AndroidSchedulers.mainThread())

}
