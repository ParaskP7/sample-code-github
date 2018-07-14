package io.petros.github.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor() : Interceptor {

    companion object {

        private const val HEADER_VERSION = "Accept"
        private const val HEADER_VERSION_VALUE = "application/vnd.github.v3+json"

    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain
            .request()
            .newBuilder()
            .addHeader(HEADER_VERSION, HEADER_VERSION_VALUE)
            .build()
        return chain.proceed(newRequest)
    }

}
