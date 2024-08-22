package com.example.galacticbook.domain

import com.example.galacticbook.model.CharacterDetails
import com.example.galacticbook.model.CharactersListResponse
import io.reactivex.rxjava3.core.Single

interface GalacticProvider {
    fun fetchAliens(page: Int): Single<CharactersListResponse>
    fun alienDetails(id: Int): Single<CharacterDetails>
}