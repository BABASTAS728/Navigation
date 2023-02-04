package com.example.navigation.domain

interface Repository {
    fun getFilmsList(): List<UiItem>
}