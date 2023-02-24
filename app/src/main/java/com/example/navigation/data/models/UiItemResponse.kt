package com.example.navigation.data.models

data class UiItemResponse(
    val category: String? = null,
    val films: List<FilmResponse?> = listOf(null)
)
