package com.example.simuladordevader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simuladordevader.databinding.ActivityConsultarMisionesBinding

class ConsultarMisiones : AppCompatActivity() {
    lateinit var binding: ActivityConsultarMisionesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_consultar_misiones)
        binding = ActivityConsultarMisionesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}