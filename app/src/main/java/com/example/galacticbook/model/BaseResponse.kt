package com.example.galacticbook.model

import com.google.gson.annotations.SerializedName

open class BaseResponse {
    @SerializedName("error")
    val error: String? = null

    @SerializedName("error_description")
    val errorDescription: String? = null
}
