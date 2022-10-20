package com.example.listas

import Model.Registro
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listas.databinding.ActivityVentanaRegistroBinding

class VentanaRegistro : AppCompatActivity() {
    lateinit var binding: ActivityVentanaRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventana_registro)
        binding.btnConfirmarRegistro.setOnClickListener {
            val Nombre = binding.txtNombre.text.toString()
            val Contraseña = binding.txtContraseA.text.toString()
            var n = Registro(Nombre, Contraseña)
            val intent = Intent()
            intent.putExtra("reg", n)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        binding.btnVolver.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}