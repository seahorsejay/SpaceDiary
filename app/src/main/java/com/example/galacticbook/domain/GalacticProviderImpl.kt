package com.example.galacticbook.domain

import com.example.galacticbook.model.CharacterDetails
import com.example.galacticbook.model.CharactersListResponse
import com.example.galacticbook.model.GalacticApi
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GalacticProviderImpl @Inject constructor(
    private val api: GalacticApi
) : GalacticProvider {
    override fun fetchAliens(page: Int): Single<CharactersListResponse> {
        return api.fetchAliens(page)
    }

    override fun alienDetails(id: Int): Single<CharacterDetails> {
        return api.alienDetails(id)
    }
}