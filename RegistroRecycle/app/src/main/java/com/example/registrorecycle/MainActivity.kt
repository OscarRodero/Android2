package com.example.registrorecycle

import Modelo.Almacen
import Modelo.Apunte
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registrorecycle.databinding.ActivityMainBinding
import com.example.registrorecycle.databinding.ActivityRegistroBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var resultLauncher = registerForActivityResult(ActivityRegistroBinding.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data
            // Get data from Intent
            val apunte = data!!.getSerializableExtra("objRegistro") as Apunte
            Almacen.addApunte(apunte)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegistrar.setOnClickListener(){
            intent = Intent(this, Registro::class.java)
            resultLauncher(intent)
        }
    }
}