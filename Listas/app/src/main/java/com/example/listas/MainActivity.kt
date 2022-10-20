package com.example.listas
import Model.Registro
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Botón Registrarse
        binding.btnRegistrarse.setOnClickListener {
            var inte: Intent = Intent(this,VentanaRegistro::class.java)
            startActivityForResult(inte, 0)

        }

        //Botón Listar
        binding.btnListar.setOnClickListener {
            var inte: Intent = Intent(this,VentanaListado::class.java)
            startActivity(inte)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==0){
            if(resultCode== Activity.RESULT_OK){

            }
        }
    }
}