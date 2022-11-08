package com.example.simuladordevader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simuladordevader.databinding.ActivityRankingPilotosBinding

class RankingPilotos : AppCompatActivity() {
    lateinit var binding: ActivityRankingPilotosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking_pilotos)
        binding = ActivityRankingPilotosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCerrarRanking.setOnClickListener(){
            finish()
        }
    }
}