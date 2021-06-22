package com.kerubyte.retropunk.data.api

import com.kerubyte.retropunk.domain.model.Beer
import com.kerubyte.retropunk.domain.model.BeerResponse
import retrofit2.Response

interface BeerServiceHelper {
    suspend fun getAllBeers(): Response<BeerResponse>
    suspend fun getSingleBeer(beerId: String): Response<Beer>
}