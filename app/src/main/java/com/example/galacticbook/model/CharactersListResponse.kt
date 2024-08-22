package com.example.galacticbook.model

data class CharactersListResponse(
    val info: Info,
    val results: List<CharacterDetails>
):BaseResponse()