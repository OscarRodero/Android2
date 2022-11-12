package com.example.simuladordevader

import Modelos.Nave
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simuladordevader.databinding.ActivityAltaNavesBinding

class AltaNaves : AppCompatActivity() {
    lateinit var binding:ActivityAltaNavesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_alta_naves)
        binding = ActivityAltaNavesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDarDeAltaNave.setOnClickListener(){
            if(!binding.etxtMatriculaNaveAlta.text.toString().equals("")){
                var tipoNave:String
                if(binding.rbtnBombarderos.isChecked){
                    tipoNave="Bombardero"
                }else if(binding.rbtnCazas.isChecked){
                    tipoNave="Caza"
                }else{
                    tipoNave="Transporte"
                }
                var n = Nave(binding.etxtMatriculaNaveAlta.text.toString(), tipoNave, binding.chkBoxCarga.isChecked, binding.chkBoxPasajeros.isChecked, null)
                Conexion.Conexion.addNave(this, n)
            }
        }
        binding.btnCancelarAltaNaves.setOnClickListener(){
            finish()
        }

        binding.btnSeleccionarImagen.setOnClickListener(){

        }
        binding.rbtnCazas.setOnClickListener(){
            binding.chkBoxCarga.isChecked=false
            binding.chkBoxPasajeros.isChecked=false
            binding.chkBoxCarga.isEnabled=false
            binding.chkBoxPasajeros.isEnabled=false
        }
        binding.rbtnBombarderos.setOnClickListener(){
            binding.chkBoxCarga.isEnabled=true
            binding.chkBoxPasajeros.isEnabled=true
        }
        binding.rbtnTransporte.setOnClickListener(){
            binding.chkBoxCarga.isEnabled=true
            binding.chkBoxPasajeros.isEnabled=true
        }
    }
}