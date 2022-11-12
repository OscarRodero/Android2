package com.example.simuladordevader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simuladordevader.databinding.ActivityAltaPilotosBinding

class AltaPilotos : AppCompatActivity() {
    lateinit var binding: ActivityAltaPilotosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_alta_pilotos)
        binding = ActivityAltaPilotosBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}