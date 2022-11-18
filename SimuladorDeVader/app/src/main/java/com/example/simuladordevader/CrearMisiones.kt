package com.example.simuladordevader

import Adaptadores.AdaptadorNavesAltaMisiones
import Adaptadores.AdaptadorPilotosAltaMisiones
import Conexion.Conexion
import Modelos.Mision
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simuladordevader.databinding.ActivityCrearMisionesBinding

class CrearMisiones : AppCompatActivity() {
    lateinit var binding:ActivityCrearMisionesBinding
    lateinit var miRVpilotos:RecyclerView
    lateinit var miRVnaves:RecyclerView

    //Variables de la misión
    lateinit var tipoMision: String
    lateinit var nombrePiloto:String
    lateinit var matriculaNave:String
    var tiempoVuelo:Int=0
    var cantObjetivos:Int=0
    var numCazas:Int=0
    var llevaCargamento:Int=0
    var llevaPasajeros:Int=0

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode== Activity.RESULT_OK){
            val data: Intent? = result.data
            val retornado = data!!.getIntExtra("tipoMision")
            if (retornado == 1) {
                tipoMision="Vuelo"
                tiempoVuelo=data!!.getIntExtra("tiempoVuelo")
            }else if(retornado == 2){
                tipoMision="Bombardeo"
                tiempoVuelo=0
                numCazas=0
                cantObjetivos= data!!.getIntExtra("cantCazas")
                llevaCargamento=data!!.getIntExtra("llevaCargamento")
                llevaPasajeros=data!!.getIntExtra("llevaPasajeros")
            }else if(retornado == 3){
                tipoMision="Combate"
                tiempoVuelo=0
                cantObjetivos=0
                llevaCargamento=0
                llevaPasajeros=0
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


        miRVnaves = binding.rvNaves as RecyclerView
        miRVnaves.setHasFixedSize(true)
        miRVnaves.layoutManager = LinearLayoutManager(this)
        var miAdaptadorNaves = AdaptadorNavesAltaMisiones(Conexion.obtenerNaves(this), this)
        miRVnaves.adapter=miAdaptadorNaves

        binding.btnTipoMision.setOnClickListener(){
            val intent = Intent(this, SeleccionadorDeTiposDeMision::class.java)
            resultLauncher.launch(intent)
        }
        binding.btnCrearMision.setOnClickListener(){
            if(!Conexion.comprobarMisionExistente(this, binding.etxtIDMision.text.toString().toInt())){
                var m:Mision=Mision(binding.etxtIDMision.text.toString().toInt(), tipoMision, nombrePiloto, matriculaNave, tiempoVuelo, cantObjetivos, numCazas, llevaCargamento, llevaPasajeros, 0, 0)
                Conexion.addMision(this, m)
                finish()
            }else{
                Toast.makeText(this,"Debe asignar una ID válida a la misión", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnCancelarCrearMision.setOnClickListener(){
            finish()
        }
    }
}

private fun Intent.getIntExtra(s: String): Int {
    return s.toInt()
}
