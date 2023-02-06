package com.example.navigation.data

import com.example.navigation.data.mappers.UiItemMapper
import com.example.navigation.domain.Repository
import com.example.navigation.domain.UiItem
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val service: Server,
    private val mapper: UiItemMapper
) : Repository {
    override fun getFilmsList(): List<UiItem> = service.getResponse().map { mapper(it) }
}