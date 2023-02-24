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
import com.example.navigation.databinding.FragmentLowRatingFilmsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LowRatingFilmsFragment : Fragment() {

    private val viewModel by viewModels<FilmsViewModel>()
    private var _binding: FragmentLowRatingFilmsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLowRatingFilmsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recycler = binding.recycler2
        val itemClick: (String, String, Int) -> Unit = { name, description, id ->
            val action =
                LowRatingFilmsFragmentDirections.actionLowRatingFilmsFragmentToDescriptionFragment(name, description, id)
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