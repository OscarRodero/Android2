package com.example.simuladordevader

import Adaptadores.AdaptadorPilotosAltaMisiones
import Conexion.Conexion
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simuladordevader.databinding.ActivityRankingPilotosBinding

class RankingPilotos : AppCompatActivity() {
    lateinit var binding: ActivityRankingPilotosBinding
    lateinit var miRVpilotos:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_ranking_pilotos)
        binding = ActivityRankingPilotosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        miRVpilotos = binding.ranking as RecyclerView
        miRVpilotos.setHasFixedSize(true)
        miRVpilotos.layoutManager = LinearLayoutManager(this)
        var miAdaptadorPilotos = AdaptadorPilotosAltaMisiones(Conexion.obtenerPilotosPorExperiencia(this), this)
        miRVpilotos.adapter=miAdaptadorPilotos


        binding.btnCerrarRanking.setOnClickListener(){
            finish()
        }
    }
}