package com.example.navigation.data.mappers

import com.example.navigation.data.models.UiItemResponse
import com.example.navigation.domain.models.UiItem
import javax.inject.Inject

class UiItemMapper @Inject constructor() {
    operator fun invoke(response: UiItemResponse, id: Int): List<UiItem> {
        val list: MutableList<UiItem> =
            mutableListOf(UiItem.Header(tittle = response.category ?: ""))
        var filmId = id
        for (i: Int in 0 until response.films.size) {
            list.add(
                UiItem.Film(
                    poster = response.films[i]?.poster ?: "",
                    name = response.films[i]?.name ?: "",
                    hasOscar = response.films[i]?.hasOscar ?: false,
                    rating = response.films[i]?.rating ?: 0.0,
                    description = response.films[i]?.description ?: "",
                    id = filmId
                )
            )
            filmId+=1
        }
        return list
    }
}