package com.example.navigation.ui

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.navigation.databinding.FilmLayoutBinding
import com.example.navigation.domain.models.UiItem

class FilmViewHolder(
    private val binding: FilmLayoutBinding,
    private val itemClick: (String, String, Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(film: UiItem.Film) {
        Glide
            .with(itemView.context)
            .load(film.poster)
            .into(binding.poster)
        binding.name.text = film.name
        binding.oscar.isVisible = film.hasOscar
        binding.rating.text = film.rating.toString()

        itemView.setOnClickListener {
            itemClick.invoke(film.name, film.description, film.id)
        }
    }
}