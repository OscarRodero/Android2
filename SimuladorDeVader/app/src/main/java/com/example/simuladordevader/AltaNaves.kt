package com.example.simuladordevader

import Modelos.Nave
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.simuladordevader.databinding.ActivityAltaNavesBinding

class AltaNaves : AppCompatActivity() {
    lateinit var binding:ActivityAltaNavesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_alta_naves)
        binding = ActivityAltaNavesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnDarAltaNaves.setOnClickListener(){
            if(!binding.etxtMatriculaNaveAlta.text.toString().equals("")){
                var tipoNave:String
                if(binding.rbtnBombarderos.isChecked){
                    tipoNave="Bombardero"
                }else if(binding.rbtnCazas.isChecked){
                    tipoNave="Caza"
                }else{
                    tipoNave="Transporte"
                }
                var x:Int
                var y:Int
                if(binding.chkBoxCarga.isChecked){
                    x=1
                }else{x=0}
                if(binding.chkBoxPasajeros.isChecked){
                    y=1
                }else{y=0}
                var n = Nave(binding.etxtMatriculaNaveAlta.text.toString(),tipoNave,x,y,null)
                Conexion.Conexion.addNave(this, n)
                Toast.makeText(this, "He entrado", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "No he entrado", Toast.LENGTH_LONG).show()
            }
        }
        binding.btnCancelarAltaNaves.setOnClickListener(){
            finish()
        }

        binding.btnSeleccionarImagen.setOnClickListener(){
            if(Conexion.Conexion.buscarNave(this, binding.etxtMatriculaNaveAlta.text.toString())!=null){
                Toast.makeText(this, "Encontrado", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "No Encontrado", Toast.LENGTH_LONG).show()
            }
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