package com.example.sqlito

import Adaptadores.MiAdaptadorRecycler
import Modelo.Factoria
import Modelo.Persona
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlito.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var miRecyclerView: RecyclerView
    lateinit var binding: ActivityMainBinding
    var miAdapter  = MiAdaptadorRecycler(Factoria.MisPersonas, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        miRecyclerView = binding.RV as RecyclerView
        miRecyclerView.setHasFixedSize(true)
        miRecyclerView.layoutManager = LinearLayoutManager(this)

        miAdapter = MiAdaptadorRecycler(Factoria.MisPersonas, this)
        miRecyclerView.adapter = miAdapter

        binding.btnAdd.setOnClickListener(){
            if(!binding.etxtDNI.text.equals("") && !binding.etxtNombre.text.equals("") && !binding.etxtEdad.text.equals("")){
                var p = Persona(binding.etxtDNI.text.toString(), binding.etxtNombre.text.toString(), binding.etxtEdad.text.toString())
                Factoria.MisPersonas.add(p)
                Log.e("Oscar", Factoria.MisPersonas.toString())
                miAdapter.notifyDataSetChanged()
            }
        }

        binding.btnBuscar.setOnClickListener(){
            if(!binding.etxtDNI.text.toString().equals("")){
                for(Persona in Factoria.MisPersonas){
                    if(Persona.DNI.equals(binding.etxtDNI.text.toString())){
                        binding.etxtNombre.setText(Persona.Nombre.toString())
                        binding.etxtEdad.setText(Persona.Edad.toString())
                    }
                }
            }
        }
        /*
        binding.btnBorrar.setOnClickListener(){

        }
        binding.btnEditar.setOnClickListener(){

        }*/
    }
}