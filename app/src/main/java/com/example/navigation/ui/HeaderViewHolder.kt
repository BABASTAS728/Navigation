package com.example.navigation.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.R
import com.example.navigation.domain.models.UiItem

class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(header: UiItem.Header) {
        itemView.findViewById<TextView>(R.id.text).text = header.tittle
    }
}
