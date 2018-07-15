package io.petros.github.data.network.rest.mapper.subscriber

import io.petros.github.data.network.rest.response.subscriber.Sub
import io.petros.github.domain.model.subscriber.Subscriber
import io.petros.github.domain.model.subscriber.SubscriberResults

class SubscriberMapper { // MIT

    companion object {

        internal fun transform(subs: Array<Sub>): SubscriberResults {
            val subscribers = arrayListOf<Subscriber>()
            for (sub in subs) {
                subscribers.add(sub.toSubscriber())
            }
            return SubscriberResults(subscribers)
        }

    }

}

fun Sub.toSubscriber(): Subscriber {
    return Subscriber(
        id = id,
        login = login,
        avatar = avatar_url
    )
}
