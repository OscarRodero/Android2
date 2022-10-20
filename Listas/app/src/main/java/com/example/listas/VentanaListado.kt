package com.example.listas

import Model.Almacen
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter

class VentanaListado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventana_listado)
        val adaptador = ArrayAdapter(this,R.layout.item_layout, R.id.txtRegistro, Almacen.Almacenaje)
    }
}