package com.kerubyte.retropunk.data

import com.kerubyte.retropunk.data.api.BeerServiceHelper
import javax.inject.Inject

class BeerRepository
@Inject
constructor(
    private val beerServiceHelper: BeerServiceHelper
) {
    suspend fun getAllBeers() = beerServiceHelper.getAllBeers()
}