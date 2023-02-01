package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class FirFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fir, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val action = FirFragmentDirections.actionFirFragmentToSecFragment(9)
            findNavController().navigate(action)
        }
    }
}