package com.example.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class VentanaListado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventana_listado)
        val adaptador = ArrayAdapter(this,R.layout.item_lista, R.id.txtItem, Almacen)
    }
}