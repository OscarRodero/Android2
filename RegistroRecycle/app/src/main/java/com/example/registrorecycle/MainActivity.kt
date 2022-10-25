package com.example.registrorecycle

import Modelo.Almacen
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registrorecycle.databinding.ActivityMainBinding
import com.example.registrorecycle.databinding.ActivityRegistroBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var resultLauncher = registerForActivityResult(ActivityRegistroBinding.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data
            // Get data from Intent
            val re: Registro = data!!.getSerializableExtra("objRegistro") as Registro
            Almacen.addRegistro(re)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegistrar.setOnClickListener(){
            intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }
    }
}