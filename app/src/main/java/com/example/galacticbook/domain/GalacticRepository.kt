package com.example.galacticbook.domain

import com.example.galacticbook.model.CharacterDetails
import com.example.galacticbook.model.CharactersListResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface GalacticRepository {
    fun fetchAliens(page: Int): Single<CharactersListResponse>
    fun alienDetails(id: Int): Single<CharacterDetails>
}

class GalacticRepositoryImpl @Inject constructor(
    private val apiProvider: GalacticProvider
) : GalacticRepository {
    override fun fetchAliens(page: Int): Single<CharactersListResponse> {
        return apiProvider.fetchAliens(page)
    }

    override fun alienDetails(id: Int): Single<CharacterDetails> {
        return apiProvider.alienDetails(id)
    }

}