package com.example.ejerciciorecycleviewdef

import Adaptadores.MiAdaptadorRecycler
import Modelo.Contacto
import Modelo.Factoria
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciorecycleviewdef.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var contactos = Factoria.generarAgenda(10)

    lateinit var miRecyclerView: RecyclerView
    lateinit var binding:ActivityMainBinding

    var resultLauncher = registerForActivityResult(ActivityMainBinding.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data
            // Get data from Intent
            val contacto = data!!.getSerializableExtra("contact") as Contacto
            contactos.add(contacto)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        miRecyclerView = binding.rvLista as RecyclerView
        miRecyclerView.setHasFixedSize(true)
        miRecyclerView.layoutManager = LinearLayoutManager(this)
        var miAdaptador = MiAdaptadorRecycler(contactos, this)
        miRecyclerView.adapter = miAdaptador

        binding.btnAAdirContacto.setOnClickListener{
            var intent = Intent(this, VistaNuevoContacto::class.java)
            resultLauncher(intent)
        }

        binding.btnDetalles.setOnClickListener{
            if(MiAdaptadorRecycler.seleccionado>=0){
                val contact = contactos.get(MiAdaptadorRecycler.seleccionado)
                Log.e("Óscar", contact.toString())
                Toast.makeText(this, contact.toString(), Toast.LENGTH_SHORT)
            }
        }
    }
}