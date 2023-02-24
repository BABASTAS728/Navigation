package com.example.navigation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.R
import com.example.navigation.data.Server
import com.example.navigation.databinding.FragmentLikeFilmsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LikeFilmsFragment : Fragment() {

    private var _binding: FragmentLikeFilmsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentLikeFilmsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recycler = binding.recycler3
        val itemClick: (String, String, Int) -> Unit = { name, description, id ->
            val action =
                LikeFilmsFragmentDirections.actionLikeFilmsFragmentToDescriptionFragment(
                    name,
                    description,
                    id
                )
            findNavController().navigate(action)
        }

        CoroutineScope(Dispatchers.Main).launch {
            val likeFilms = Server.getFilmsById(Server.getUser().likeFilms)
            val adapter = FilmsAdapter(likeFilms, itemClick)
            recycler.adapter = adapter
            recycler.layoutManager =
                LinearLayoutManager(
                    this@LikeFilmsFragment.context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
