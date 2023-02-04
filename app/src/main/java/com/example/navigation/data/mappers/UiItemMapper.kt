package com.example.navigation.data.mappers

import com.example.navigation.data.models.UiItemResponse
import com.example.navigation.domain.UiItem
import javax.inject.Inject

class UiItemMapper @Inject constructor() {
    operator fun invoke(response: UiItemResponse) =
        when (response) {
            is UiItemResponse.Film -> {
                with(response) {
                    UiItem.Film(
                        poster = poster ?: "",
                        name = name ?: "",
                        hasOscar = hasOscar ?: false,
                        rating = rating ?: 0.0,
                        description = description ?: ""
                    )
                }
            }
            is UiItemResponse.Header -> UiItem.Header(tittle = response.tittle ?: "")
        }
}