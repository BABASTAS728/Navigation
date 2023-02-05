package com.example.navigation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LowRatingFilmsFragment : Fragment() {

    private val viewModel by viewModels<FilmsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_low_rating_films, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recycler = view.findViewById<RecyclerView>(R.id.recycler2)
        val itemClick: (String, String) -> Unit = { name, description ->
            val action =
                LowRatingFilmsFragmentDirections.actionLowRatingFilmsFragmentToDescriptionFragment(name, description)
            findNavController().navigate(action)
        }

        viewModel.liveData.observe(viewLifecycleOwner) {
            val adapter = FilmsAdapter(it, itemClick)
            recycler.adapter = adapter
            recycler.layoutManager =
                LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        }

        viewModel.getLowRatingFilms()
    }
}