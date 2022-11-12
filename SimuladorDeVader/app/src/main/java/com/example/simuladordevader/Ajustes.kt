package com.example.simuladordevader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simuladordevader.databinding.ActivityAjustesBinding
import com.example.simuladordevader.databinding.ActivityAltaNavesBinding

class Ajustes : AppCompatActivity() {
    lateinit var binding:ActivityAjustesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_ajustes)
        binding = ActivityAjustesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}