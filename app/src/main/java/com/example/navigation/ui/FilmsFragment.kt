package com.example.navigation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmsFragment : Fragment() {

    private val viewModel by viewModels<FilmsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_films, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        val itemClick: (String, String, Int) -> Unit = { name, description, id ->
            val action = FilmsFragmentDirections.actionFilmsFragmentToDescriptionFragment(name, description, id)
            findNavController().navigate(action)
        }

        viewModel.liveData.observe(viewLifecycleOwner) {
            view.findViewById<ProgressBar>(R.id.progressBar).isVisible = false
            val adapter = FilmsAdapter(it, itemClick)
            recycler.adapter = adapter
            recycler.layoutManager =
                LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        }

        viewModel.getFilms()

        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener{
            val action = FilmsFragmentDirections.actionFilmsFragmentToLowRatingFilmsFragment()
            findNavController().navigate(action)
        }

        viewModel.errorLiveData.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), getString(it), Toast.LENGTH_SHORT).show()
        }

        viewModel.loadingLiveData.observe(viewLifecycleOwner){
            view.findViewById<ProgressBar>(R.id.progressBar).isVisible = true
        }

        val likeButton = view.findViewById<Button>(R.id.checkLikeFilmsBtn)
        likeButton.setOnClickListener{
            val action = FilmsFragmentDirections.actionFilmsFragmentToLikeFilmsFragment()
            findNavController().navigate(action)
        }
    }
}