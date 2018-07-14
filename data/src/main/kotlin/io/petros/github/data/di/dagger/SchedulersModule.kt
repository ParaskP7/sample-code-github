package io.petros.github.data.di.dagger

import dagger.Module
import dagger.Provides
import io.petros.github.data.reactive.rx.Rx
import io.petros.github.domain.reactive.rx.RxSchedulers

@Module
class SchedulersModule {

    @Provides
    fun provideDefaultRxSchedulers(): RxSchedulers = Rx.defaultSchedulers()

}
