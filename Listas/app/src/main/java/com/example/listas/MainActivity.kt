package com.example.listas
import Model.Almacen
import Model.Registro
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.listas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var resultlauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result->
        val data: Intent? = result.data
        val NuevoRegistro: Registro = data!!.getSerializableExtra("reg") as Registro
        Almacen.addRegistro(NuevoRegistro)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Botón Registrarse
        binding.btnRegistrarse.setOnClickListener {
            var intent = Intent(this,VentanaRegistro::class.java)
            resultlauncher.launch(intent)
        }

        //Botón Listar
        binding.btnListar.setOnClickListener {
            var intent = Intent(this,VentanaListado::class.java)
            intent.putExtra("MisDatos", Almacen.Almacenaje)
            startActivity(intent)
        }

    }
}