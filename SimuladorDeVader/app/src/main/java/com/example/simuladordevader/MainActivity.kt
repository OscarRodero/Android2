package com.example.simuladordevader

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
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
        binding.Inicio.setOnClickListener(){
            inte = Intent(this, Login::class.java)
            resultLauncher.launch(inte)
        }

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
        }
        return super.onOptionsItemSelected(item)
    }

    private fun abrirAltaPilotos() {
        TODO("Not yet implemented")
    }

    private fun abrirAltaNaves() {
        inte = Intent(this, AltaNaves::class.java)
        startActivity(inte)
    }

    private fun abrirCrearMisiones() {
        TODO("Not yet implemented")
    }

    private fun abrirRankingPilotos() {
        inte = Intent(this, RankingPilotos::class.java)
        startActivity(inte)
    }
}