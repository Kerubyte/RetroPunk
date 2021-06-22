package com.kerubyte.retropunk.data.api

import com.kerubyte.retropunk.domain.model.Beer
import com.kerubyte.retropunk.domain.model.BeerResponse
import retrofit2.Response
import javax.inject.Inject

class BeerServiceImpl
@Inject
constructor(
    private val beerService: BeerService
) : BeerServiceHelper {
    override suspend fun getAllBeers(): Response<BeerResponse> =
        beerService.getAllBeers()

    override suspend fun getSingleBeer(beerId: String): Response<Beer> =
        beerService.getSingleBeer(beerId)


}