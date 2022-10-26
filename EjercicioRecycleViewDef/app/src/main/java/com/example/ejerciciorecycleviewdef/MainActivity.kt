package com.example.ejerciciorecycleviewdef

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciorecycleviewdef.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var miRecyclerView: RecyclerView
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}