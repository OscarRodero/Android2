package com.example.simuladordevader

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.simuladordevader.databinding.ActivityCrearMisionesBinding

class CrearMisiones : AppCompatActivity() {
    lateinit var binding:ActivityCrearMisionesBinding
    lateinit var tipoMision:String
    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode== Activity.RESULT_OK){
            val data: Intent? = result.data
            val retornado = data!!.getStringExtra("tipoMision")
            if (retornado != null) {
                this.tipoMision=retornado
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