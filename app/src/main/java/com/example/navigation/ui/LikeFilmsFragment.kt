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
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LikeFilmsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_like_films, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recycler = view.findViewById<RecyclerView>(R.id.recycler3)
        val itemClick: (String, String, Int) -> Unit = { name, description, id ->
            val action =
                LikeFilmsFragmentDirections.actionLikeFilmsFragmentToDescriptionFragment(
                    name,
                    description,
                    id
                )
            findNavController().navigate(action)
        }

        CoroutineScope(Dispatchers.IO).launch {
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
}
