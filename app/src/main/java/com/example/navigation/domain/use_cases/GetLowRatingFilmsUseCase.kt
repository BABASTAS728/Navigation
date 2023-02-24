package com.example.navigation.domain.use_cases

import com.example.navigation.domain.Repository
import com.example.navigation.domain.models.UiItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetLowRatingFilmsUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(): List<UiItem> = withContext(Dispatchers.IO) {
        repository.getFilmsList().filter {
            when (it) {
                is UiItem.Film -> it.rating < LOW_RATING
                is UiItem.Header -> it.tittle.isEmpty()
            }
        }
    }

    companion object {
        private const val LOW_RATING = 7.0
    }
}