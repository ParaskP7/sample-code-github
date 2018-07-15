package io.petros.github.test.domain

import io.petros.github.domain.model.subscriber.Subscriber
import io.petros.github.domain.model.subscriber.SubscriberResults

class TestSubscriberProvider {

    companion object {

        private const val ID = 1
        private const val AVATAR = "AVATAR"
        private const val LOGIN = "LOGIN"

        fun provideSubscriberResults(
            subscribers: List<Subscriber> = arrayListOf(provideSubscriber(), provideSubscriber(), provideSubscriber())
        ): SubscriberResults {
            return SubscriberResults(
                subscribers
            )
        }

        fun provideSubscriber(
            id: Int = ID,
            login: String = LOGIN,
            avatar: String = AVATAR
        ): Subscriber {
            return Subscriber(
                id,
                login,
                avatar
            )
        }

    }

}
