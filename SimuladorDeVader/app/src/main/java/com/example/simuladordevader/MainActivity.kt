package com.example.simuladordevader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.simuladordevader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var inte:Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onCreateOptionsMenu(menu: Menu?):Boolean{
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean{
        when(item.itemId){ //Cada una es una de las opciones, cambiar al gusto.
            R.id.menuAltaPilotos -> Toast.makeText(this, "Alta Pilotos",Toast.LENGTH_LONG).show()
            R.id.menuAltaNaves -> abrirAltaNaves()
            R.id.menuCrearMisiones -> Toast.makeText(this, "Crear Misiones",Toast.LENGTH_LONG).show()
            R.id.menuRankingPilotos -> abrirRankingPilotos()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun abrirAltaNaves() {
        TODO("Not yet implemented")
    }

    private fun abrirRankingPilotos() {
        inte = Intent(this, RankingPilotos::class.java)
        Log.e("Oscar",inte.toString())
        startActivity(inte)
    }
}