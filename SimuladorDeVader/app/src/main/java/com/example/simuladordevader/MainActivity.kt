package com.example.simuladordevader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.simuladordevader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
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
            R.id.menuAltaPilotos -> Toast.makeText(this, "Guardar",Toast.LENGTH_LONG).show()
            R.id.menuAltaNaves -> Toast.makeText(this, "Perfil",Toast.LENGTH_LONG).show()
            R.id.menuCrearMisiones -> Toast.makeText(this, "Salir",Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }
}