package com.example.galacticbook.domain

import com.example.galacticbook.model.CharactersListResponse

sealed class GalaxyState {
    object Loading : GalaxyState()
    data class Content(val content: CharactersListResponse) : GalaxyState()
    data class Error(val msg: String) : GalaxyState()
}