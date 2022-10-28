package com.example.ejerciciorecycleviewdef

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejerciciorecycleviewdef.databinding.ActivityVistaNuevoContactoBinding

class VistaNuevoContacto : AppCompatActivity() {
    lateinit var binding: ActivityVistaNuevoContactoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista_nuevo_contacto)
        binding.btnSeleccionarImagen.setOnClickListener{

        }

    }
}