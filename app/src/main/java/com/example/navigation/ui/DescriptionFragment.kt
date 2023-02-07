package com.example.navigation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.navigation.R
import com.example.navigation.data.Server
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DescriptionFragment : Fragment() {

    private val args: DescriptionFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<TextView>(R.id.name).text = args.name
        view.findViewById<TextView>(R.id.description).text = args.description
        view.findViewById<Button>(R.id.likeButton).setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                Server.getUser().likeFilms.add(args.id)
            }
        }
    }
}