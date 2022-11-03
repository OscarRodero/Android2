package com.example.sqlito

import Adaptadores.MiAdaptadorRecycler
import Modelo.Factoria
import Modelo.Persona
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlito.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var miRecyclerView: RecyclerView
    lateinit var binding: ActivityMainBinding
    var Personas = Factoria.MisPersonas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        miRecyclerView = binding.RV as RecyclerView
        miRecyclerView.setHasFixedSize(true)
        miRecyclerView.layoutManager = LinearLayoutManager(this)
        var miAdapter = MiAdaptadorRecycler(Personas, this)
        miRecyclerView.adapter = miAdapter

        binding.btnAdd.setOnClickListener(){
            if(!binding.etxtDNI.text.equals("") && !binding.etxtNombre.text.equals("") && !binding.etxtEdad.text.equals("")){
                var p = Persona(binding.etxtDNI.text.toString(), binding.etxtNombre.text.toString(), binding.etxtEdad.text.toString())
                Factoria.MisPersonas.add(p)
            }
        }
        binding.btnBuscar.setOnClickListener(){

        }
        binding.btnBorrar.setOnClickListener(){

        }
        binding.btnEditar.setOnClickListener(){

        }
    }
}