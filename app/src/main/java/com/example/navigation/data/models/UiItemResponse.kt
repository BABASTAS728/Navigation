package com.example.navigation.data.models

sealed class UiItemResponse{
    data class Film(
        val poster: String? = null,
        val name: String? = null,
        val hasOscar: Boolean? = null,
        val rating: Double? = null,
        val description: String? = null
    ) : UiItemResponse()

    data class Header(val tittle: String? = null) : UiItemResponse()
}
