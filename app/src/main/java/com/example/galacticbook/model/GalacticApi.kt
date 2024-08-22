package com.example.galacticbook.model

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GalacticApi {
    @GET("character")
    fun fetchAliens(
        @Query("page") page: Int
    ): Single<CharactersListResponse>

    @GET("character/{id}")
    fun alienDetails(
        @Path("id") id: Int,
    ):Single<CharacterDetails>
}