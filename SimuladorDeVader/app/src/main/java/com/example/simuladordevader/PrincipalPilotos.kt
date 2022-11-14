package com.example.simuladordevader

import Conexion.Conexion
import Modelos.Piloto
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.simuladordevader.databinding.ActivityPrincipalPilotosBinding

class PrincipalPilotos : AppCompatActivity() {
    lateinit var binding: ActivityPrincipalPilotosBinding
    lateinit var inte:Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //(setContentView(R.layout.activity_principal_pilotos)
        binding = ActivityPrincipalPilotosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txtNombreStoormTrooper.setText(intent.getStringExtra("nombre"))
        var p: Piloto? = Conexion.conectar(this, binding.txtNombreStoormTrooper.text.toString())

        binding.imagenStormTrooper.setOnClickListener(){
           // binding.imagenStormTrooper.setBackgroundResource()
        }


        binding.switchMisiones.setOnCheckedChangeListener{ buttonView, isChecked ->
            if(isChecked){
                binding.switchMisiones.setText("Misiones Completadas")
                cambiarRecycleView(0)
            }else{
                binding.switchMisiones.setText("Misiones Pendientes")
                cambiarRecycleView(1)
            }
        }
    }

    private fun cambiarRecycleView(i: Int) {
        if(i==0){

        }else{

        }
    }


    override fun onCreateOptionsMenu(menu: Menu?):Boolean{
        menuInflater.inflate(R.menu.menustormtrooper, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean{
        when(item.itemId){ //Cada una es una de las opciones, cambiar al gusto.
            R.id.menuAjustes -> abrirAjustes()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun abrirConsultarMisiones() {
        inte = Intent(this, ConsultarMisiones::class.java)
        startActivity(inte)
    }
    private fun abrirAjustes() {
        inte = Intent(this, Ajustes::class.java)
        startActivity(inte)
    }
}