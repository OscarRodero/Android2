package com.example.registrorecycle

import Modelo.Almacen
import Modelo.Apunte
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registrorecycle.databinding.ActivityRegistroBinding

class Registro : AppCompatActivity() {
    lateinit var binding: ActivityRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_registro)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //boton Confirmar Registro
        binding.btnConfirmarRegistro.setOnClickListener(){
            if(binding.etxtNombre.text.toString()!="" && binding.etxtApellidos.text.toString()!=""){
                var n = Apunte(binding.etxtNombre.text.toString(), binding.etxtApellidos.text.toString())
                Almacen.addRegistro(n)
                finish()
            }
        }

        //Botón Cancelar
        binding.btnCancelar.setOnClickListener(){
            finish()
        }
    }
}