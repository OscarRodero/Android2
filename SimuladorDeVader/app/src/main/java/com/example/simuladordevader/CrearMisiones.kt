package com.example.simuladordevader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simuladordevader.databinding.ActivityCrearMisionesBinding

class CrearMisiones : AppCompatActivity() {
    lateinit var binding:ActivityCrearMisionesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_crear_misiones)
        binding = ActivityCrearMisionesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}