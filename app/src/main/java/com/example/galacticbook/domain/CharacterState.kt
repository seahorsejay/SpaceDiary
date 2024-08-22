package com.example.galacticbook.domain

import com.example.galacticbook.model.CharacterDetails
import com.example.galacticbook.model.CharactersListResponse

sealed class CharacterState {
    object Loading : CharacterState()
    data class Content(val content: CharacterDetails) : CharacterState()
    data class Error(val msg: String) : CharacterState()
}