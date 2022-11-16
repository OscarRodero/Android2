package com.example.simuladordevader

import Modelos.Piloto
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import com.example.simuladordevader.databinding.ActivityAltaPilotosBinding

class AltaPilotos : AppCompatActivity() {
    lateinit var binding: ActivityAltaPilotosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_alta_pilotos)
        binding = ActivityAltaPilotosBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.sbExp.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                var progreso = binding.sbExp.progress
                binding.txtExperiencia.setText(progreso.toString())
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                var progreso = binding.sbExp.progress
                binding.txtExperiencia.setText(progreso.toString())
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                var progreso = binding.sbExp.progress
                binding.txtExperiencia.setText(progreso.toString())
            }
        })

        binding.btnDarAltaPiloto.setOnClickListener(){
            if(!binding.etxtNombre.text.toString().equals("") && !binding.etxtEdad.text.toString().equals("") && !binding.etxtContraseAPilotos.text.toString().equals("")){
                var p = Piloto(binding.etxtNombre.text.toString(), binding.etxtEdad.text.toString().toInt(), binding.sbExp.progress.toInt(), binding.etxtContraseAPilotos.text.toString())
                Conexion.Conexion.addPiloto(this, p)
                Toast.makeText(this, "Piloto registrado con éxito", Toast.LENGTH_LONG).show()
            }
        }
        binding.btnCancelarAltaPilotos.setOnClickListener(){
            finish()
        }
    }
}