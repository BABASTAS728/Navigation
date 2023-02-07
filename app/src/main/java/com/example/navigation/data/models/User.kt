package com.example.navigation.data.models

data class User(
    val userId: Int,
    val likeFilms: MutableList<Int>
)