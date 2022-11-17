package com.example.simuladordevader

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.simuladordevader.databinding.ActivitySeleccionadorDeTiposDeMisionBinding

class SeleccionadorDeTiposDeMision : AppCompatActivity() {
    lateinit var binding:ActivitySeleccionadorDeTiposDeMisionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_seleccionador_de_tipos_de_mision)
        binding = ActivitySeleccionadorDeTiposDeMisionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var missionType:Int=0
        //Hago desaparecer todas las otras opciones antes de empezar a seleccionar cosas
        binding.etxtCantCazas.isVisible=false
        binding.etxtCantObjetivos.isVisible=false
        binding.chkBoxLlevaCarga.isVisible=false
        binding.chkBoxLlevaPasajeros.isVisible=false

        binding.btnAceptarYContinuar.setOnClickListener(){
            when(missionType){
                1 -> devolverVuelo(missionType)
                2 -> devolverBombardeo(missionType)
                3 -> devolverCombate(missionType)
            }
        }

        //RadioButtons
        binding.rbVuelo.setOnClickListener(){
            missionType=1
            //Quito las otras dos opciones
            binding.rbBombardeo.isChecked=false
            binding.rbCombate.isChecked=false
            //Elimino las opciones que no compiten
            binding.etxtTiempoVuelo.isVisible=true
            binding.etxtCantCazas.isVisible=false
            binding.etxtCantObjetivos.isVisible=false
            //Elimino los checkbox
            binding.chkBoxLlevaCarga.isVisible=false
            binding.chkBoxLlevaPasajeros.isVisible=false
        }
        binding.rbBombardeo.setOnClickListener(){
            missionType=2
            //Quito las otras dos opciones
            binding.rbVuelo.isChecked=false
            binding.rbCombate.isChecked=false
            //Elimino las opciones que no compiten
            binding.etxtTiempoVuelo.isVisible=false
            binding.etxtCantCazas.isVisible=false
            binding.etxtCantObjetivos.isVisible=true
            //Elimino los checkbox
            binding.chkBoxLlevaCarga.isVisible=true
            binding.chkBoxLlevaPasajeros.isVisible=true
        }
        binding.rbCombate.setOnClickListener(){
            missionType=3
            //Quito las otras dos opciones
            binding.rbBombardeo.isChecked=false
            binding.rbVuelo.isChecked=false
            //Elimino las opciones que no compiten
            binding.etxtTiempoVuelo.isVisible=false
            binding.etxtCantCazas.isVisible=true
            binding.etxtCantObjetivos.isVisible=false
            //Elimino los checkbox
            binding.chkBoxLlevaCarga.isVisible=false
            binding.chkBoxLlevaPasajeros.isVisible=false
        }
    }

    private fun devolverCombate(missionType: Int) {
        TODO("Not yet implemented")
    }

    private fun devolverBombardeo(missionType: Int) {
        TODO("Not yet implemented")
    }

    private fun devolverVuelo(missionType: Int) {
        val tipomision = missionType
        val tiempoVuelo = binding.etxtTiempoVuelo.text.toString().toInt()
        val intent = Intent()
        intent.putExtra("tipoMision", tipomision)
        intent.putExtra("tiempoVuelo", tiempoVuelo)
        setResult(Activity.RESULT_OK)
        finish()
    }
}