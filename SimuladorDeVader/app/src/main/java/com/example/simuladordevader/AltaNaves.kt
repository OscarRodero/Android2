package com.example.simuladordevader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simuladordevader.databinding.ActivityAltaNavesBinding
class AltaNaves : AppCompatActivity() {
    lateinit var binding: ActivityAltaNavesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_alta_naves)
        binding = ActivityAltaNavesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}