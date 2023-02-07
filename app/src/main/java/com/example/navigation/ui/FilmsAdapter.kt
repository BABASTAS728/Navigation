package com.example.navigation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.R
import com.example.navigation.domain.models.UiItem

class FilmsAdapter(private val list: List<UiItem>, private val itemCLick: (String, String, Int) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            FILM_TYPE -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.film_layout, parent, false)
                FilmViewHolder(view, itemCLick)
            }
            TITLE_TYPE -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.header_layout, parent, false)
                HeaderViewHolder(view)
            }
            else -> throw Exception()
        }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FilmViewHolder -> holder.bind(list[position] as UiItem.Film)
            is HeaderViewHolder -> holder.bind(list[position] as UiItem.Header)
        }
    }

    override fun getItemViewType(position: Int): Int = when (list[position]) {
        is UiItem.Film -> FILM_TYPE
        is UiItem.Header -> TITLE_TYPE
        else -> throw Exception()
    }

    companion object {
        private const val TITLE_TYPE = 1
        private const val FILM_TYPE = 2
    }
}