package io.petros.github.test.rx

import io.petros.github.domain.reactive.rx.RxSchedulers
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class TestRxProvider {

    companion object {

        fun provideRxSchedulers(
            io: Scheduler = Schedulers.trampoline(),
            androidMainThread: Scheduler = Schedulers.trampoline()
        ): RxSchedulers {
            return RxSchedulers(io, androidMainThread)
        }

    }

}
