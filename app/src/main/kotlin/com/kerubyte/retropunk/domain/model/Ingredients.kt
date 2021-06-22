package com.kerubyte.retropunk.domain.model

data class Ingredients(
    val hops: List<Any>,
    val malt: List<Malt>,
    val yeast: String
)