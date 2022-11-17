package com.example.simuladordevader

import Modelos.Mision
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.simuladordevader.databinding.ActivityCrearMisionesBinding

class CrearMisiones : AppCompatActivity() {
    lateinit var binding:ActivityCrearMisionesBinding
    lateinit var tipoMision: String
    lateinit var tiempoVuelo:Int
    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode== Activity.RESULT_OK){
            val data: Intent? = result.data
            val retornado = data!!.getIntExtra("tipoMision")
            if (retornado == 1) {
                tipoMision="Vuelo"
                tiempoVuelo=data!!.getIntExtra("tiempoVuelo")
            }else if(retornado == 2){

            }else if(retornado == 3){

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_crear_misiones)
        binding = ActivityCrearMisionesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Variables


        binding.btnTipoMision.setOnClickListener(){
            val intent = Intent(this, SeleccionadorDeTiposDeMision::class.java)
            resultLauncher.launch(intent)
        }
    }
}