package com.example.simuladordevader

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View.OnTouchListener
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.simuladordevader.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var inte:Intent
    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == Activity.RESULT_OK){
            val data:Intent? = result.data
            val LogName = data!!.getStringExtra("QuienLoggea")
            val LogPassword = data!!.getStringExtra("Contraseña")

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*
        binding.Inicio.setOnClickListener(){
            inte = Intent(this, Login::class.java)
            resultLauncher.launch(inte)
        }*/
    }

    override fun onCreateOptionsMenu(menu: Menu?):Boolean{
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean{
        when(item.itemId){ //Cada una es una de las opciones, cambiar al gusto.
            R.id.menuAltaPilotos -> abrirAltaPilotos()
            R.id.menuAltaNaves -> abrirAltaNaves()
            R.id.menuCrearMisiones -> abrirCrearMisiones()
            R.id.menuRankingPilotos -> abrirRankingPilotos()
            R.id.menuAjustes -> abrirAjustes()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun abrirAjustes() {
        inte = Intent(this, Ajustes::class.java)
        startActivity(inte)
    }

    private fun abrirAltaPilotos() {
        inte = Intent(this, AltaPilotos::class.java)
        startActivity(inte)
    }

    private fun abrirAltaNaves() {
        inte = Intent(this, AltaNaves::class.java)
        startActivity(inte)
    }

    private fun abrirCrearMisiones() {
        inte = Intent(this, CrearMisiones::class.java)
        startActivity(inte)
    }

    private fun abrirRankingPilotos() {
        inte = Intent(this, RankingPilotos::class.java)
        startActivity(inte)
    }
}