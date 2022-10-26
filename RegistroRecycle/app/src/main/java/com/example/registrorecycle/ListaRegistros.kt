package com.example.registrorecycle

import Adaptadores.MiAdaptadorRecycler
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ListaRegistros : AppCompatActivity() {
    var personajes = .generaLista(12)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_registros)

        var miAdapter = MiAdaptadorRecycler(personajes, this)
        miRecyclerView.adapter = miAdapter
    }
}