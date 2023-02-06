package com.example.navigation.domain.use_cases

import com.example.navigation.domain.Repository
import com.example.navigation.domain.UiItem
import javax.inject.Inject

class GetLowRatingFilmsUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(): List<UiItem> = repository.getFilmsList().filter {
        when (it) {
            is UiItem.Film -> it.rating < LOW_RATING
            is UiItem.Header -> it.tittle.isEmpty()
        }
    }

    companion object {
        private const val LOW_RATING = 7.0
    }
}