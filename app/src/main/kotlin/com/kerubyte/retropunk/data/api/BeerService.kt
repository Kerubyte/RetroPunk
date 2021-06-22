package com.kerubyte.retropunk.data.api

import com.kerubyte.retropunk.domain.model.Beer
import com.kerubyte.retropunk.domain.model.BeerResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface BeerService {

    @GET("beers")
    suspend fun getAllBeers(
        @Query("?page")
        pageNumber: Int = 1
    ): Response<BeerResponse>

    @GET("beers/")
    suspend fun getSingleBeer(@Url beerId: String): Response<Beer>

}