package com.example.navigation.data

import com.example.navigation.data.mappers.UiItemMapper
import com.example.navigation.domain.Repository
import com.example.navigation.domain.models.UiItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val service: Server,
    private val mapper: UiItemMapper
) : Repository {
    override suspend fun getFilmsList(): List<UiItem> {
        val result: MutableList<UiItem> = mutableListOf()
        withContext(Dispatchers.IO) {
            val list = service.getResponse()
            var id = 1
            for (element in list) {
                val films = mapper(element, id)
                result.addAll(films)
                id+=films.size-1
            }
        }
        return result
    }
}