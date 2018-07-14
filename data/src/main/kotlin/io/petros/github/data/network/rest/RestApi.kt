package io.petros.github.data.network.rest

import io.petros.github.data.network.rest.response.search.SearchResultsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET("search/repositories")
    fun search(
        @Query("q") searchTerm: String
    ): Single<SearchResultsResponse>

}
