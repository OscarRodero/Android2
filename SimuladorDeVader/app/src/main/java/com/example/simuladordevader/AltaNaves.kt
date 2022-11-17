package com.example.simuladordevader

import Conexion.Conexion
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
        binding.imagenNave.setImageResource(R.drawable.tiebomber)


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
                if(Conexion.buscarNave(this, binding.etxtMatriculaNaveAlta.text.toString())==null){
                    Toast.makeText(this, "Nave añadida", Toast.LENGTH_LONG).show()
                    Conexion.addNave(this, n)
                }
            }else{
                Toast.makeText(this, "Error al añadir la nave", Toast.LENGTH_LONG).show()
            }
        }
        binding.btnCancelarAltaNaves.setOnClickListener(){
            finish()
        }

        //RadioButtons
        binding.rbtnCazas.setOnClickListener(){
            binding.imagenNave.setImageResource(R.drawable.tiefighter)
            binding.chkBoxCarga.isChecked=false
            binding.chkBoxPasajeros.isChecked=false
            binding.chkBoxCarga.isEnabled=false
            binding.chkBoxPasajeros.isEnabled=false
        }
        binding.rbtnBombarderos.setOnClickListener(){
            binding.imagenNave.setImageResource(R.drawable.tiebomber)
            binding.chkBoxCarga.isEnabled=true
            binding.chkBoxPasajeros.isEnabled=true
        }
        binding.rbtnTransporte.setOnClickListener(){
            binding.imagenNave.setImageResource(R.drawable.shuttle)
            binding.chkBoxCarga.isEnabled=true
            binding.chkBoxPasajeros.isEnabled=true
        }
    }
}