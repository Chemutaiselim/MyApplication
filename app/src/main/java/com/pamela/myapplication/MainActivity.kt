package com.pamela.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pamela.myapplication.databinding.ActivityMainBinding
lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //calculate the tip

    }
}