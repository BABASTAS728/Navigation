package com.example.navigation.domain

import com.example.navigation.domain.models.UiItem

interface Repository {
    suspend fun getFilmsList(): List<UiItem>
    suspend fun addFilm(id: Int)
}