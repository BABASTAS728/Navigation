package com.example.navigation.data.models

sealed class UiItemResponse{
    data class Film(
        val poster: String?,
        val name: String?,
        val hasOscar: Boolean?,
        val rating: Double?,
        val description: String?
    ) : UiItemResponse()

    data class Header(val tittle: String?) : UiItemResponse()
}
