package com.example.listas

import Model.Almacen
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.listas.databinding.ActivityVentanaListadoBinding

class VentanaListado : AppCompatActivity() {
    lateinit var binding: ActivityVentanaListadoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventana_listado)
        val adaptador = ArrayAdapter(this,R.layout.item_layout, R.id.txtRegistro, Almacen.Almacenaje)
        binding.listView.adapter=adaptador
        binding.btnVolverAtras.setOnClickListener {
            finish()
        }
    }
}