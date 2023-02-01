package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class SecFragment : Fragment() {

    private val args: SecFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sec, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val button = view.findViewById<Button>(R.id.button2)
        button.text = args.fromFirstToSec.toString()
        button.setOnClickListener {
            val action = SecFragmentDirections.actionSecFragmentToThirdFragment(
                args.fromFirstToSec,
                "String from second"
            )
            findNavController().navigate(action)
        }
    }

}