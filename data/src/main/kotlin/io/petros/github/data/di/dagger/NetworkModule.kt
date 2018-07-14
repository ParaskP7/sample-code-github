package io.petros.github.data.di.dagger

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import io.petros.github.data.BuildConfig
import io.petros.github.data.R
import io.petros.github.data.getLong
import io.petros.github.data.network.WebService
import io.petros.github.data.network.interceptor.HeaderInterceptor
import io.petros.github.data.network.rest.RestApi
import io.petros.github.data.network.rest.RestClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesGson() = Gson()

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        context: Context,
        headerInterceptor: HeaderInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()
            .connectTimeout(context.getLong(R.integer.network_timeout), TimeUnit.MILLISECONDS)
        okHttpBuilder.addInterceptor(headerInterceptor)
        if (BuildConfig.DEBUG) okHttpBuilder.addInterceptor(loggingInterceptor)
        return okHttpBuilder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(context: Context, gson: Gson, httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(context.getString(R.string.rest_github_url))
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideRestApi(retrofit: Retrofit): RestApi = retrofit.create(RestApi::class.java)

    @Provides
    @Singleton
    fun provideRestClient(restApi: RestApi): RestClient = RestClient(restApi)

    @Provides
    @Singleton
    fun provideWebService(restClient: RestClient): WebService = restClient

}
