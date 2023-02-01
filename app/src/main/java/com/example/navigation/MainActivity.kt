package com.example.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController(R.id.hostFragment).popBackStack()
            }
        })
    }

}