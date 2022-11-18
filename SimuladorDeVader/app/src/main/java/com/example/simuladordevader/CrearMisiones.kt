package com.example.simuladordevader

import Adaptadores.AdaptadorPilotosAltaMisiones
import Conexion.Conexion
import Modelos.Mision
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simuladordevader.databinding.ActivityCrearMisionesBinding

class CrearMisiones : AppCompatActivity() {
    lateinit var binding:ActivityCrearMisionesBinding
    lateinit var miRVpilotos:RecyclerView
    lateinit var tipoMision: String
    lateinit var nombrePiloto:String
    lateinit var matriculaNave:String
    var tiempoVuelo:Int=0
    var cantObjetivos:Int=0
    var llevaCargamento:Int=0
    var llevaPasajeros:Int=0
    var numCazas:Int=0

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode== Activity.RESULT_OK){
            val data: Intent? = result.data
            val retornado = data!!.getIntExtra("tipoMision")
            if (retornado == 1) {
                tipoMision="Vuelo"
                tiempoVuelo=data!!.getIntExtra("tiempoVuelo")
            }else if(retornado == 2){
                tipoMision="Bombardeo"
                cantObjetivos= data!!.getIntExtra("cantCazas")
                llevaCargamento=data!!.getIntExtra("llevaCargamento")
                llevaPasajeros=data!!.getIntExtra("llevaPasajeros")
            }else if(retornado == 3){
                tipoMision="Combate"
                numCazas= data!!.getIntExtra("cantCazas")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_crear_misiones)
        binding = ActivityCrearMisionesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        miRVpilotos = binding.rvPilotos as RecyclerView
        miRVpilotos.setHasFixedSize(true)
        miRVpilotos.layoutManager = LinearLayoutManager(this)
        var miAdaptadorPilotos = AdaptadorPilotosAltaMisiones(Conexion.obtenerPilotos(this), this)
        miRVpilotos.adapter=miAdaptadorPilotos


        binding.btnTipoMision.setOnClickListener(){
            val intent = Intent(this, SeleccionadorDeTiposDeMision::class.java)
            resultLauncher.launch(intent)
        }
        binding.btnCrearMision.setOnClickListener(){
            var m:Mision=Mision(binding.etxtIDMision.text.toString().toInt(), tipoMision, nombrePiloto, matriculaNave, tiempoVuelo, cantObjetivos, numCazas, llevaCargamento, llevaPasajeros)
            Conexion.addMision(this, m)
            finish()
        }
        binding.btnCancelarCrearMision.setOnClickListener(){
            finish()
        }
    }
}

private fun Intent.getIntExtra(s: String): Int {
    return s.toInt()
}
