package com.example.navigation.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.databinding.HeaderLayoutBinding
import com.example.navigation.domain.models.UiItem

class HeaderViewHolder(private val binding: HeaderLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(header: UiItem.Header) {
        binding.text.text = header.tittle
    }
}
