package com.example.calculadoramultiventana

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoramultiventana.databinding.ActivityResultadoBinding

class Resultado : AppCompatActivity() {
    lateinit var binding: ActivityResultadoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var extras = intent.extras

        if (extras != null) {
            var x = extras.get("resultado").toString()
            binding.txtResultado.setText(x)
        }
        binding.btnVolver.setOnClickListener(){
            finish()
        }
    }
}