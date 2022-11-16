package com.example.simuladordevader

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.simuladordevader.databinding.ActivityCrearMisionesBinding

class CrearMisiones : AppCompatActivity() {
    lateinit var binding:ActivityCrearMisionesBinding
    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode== Activity.RESULT_OK){
            val data:Intent? = result.data
            val returnString = data!!.getStringExtra("")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_crear_misiones)
        binding = ActivityCrearMisionesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTipoMision.setOnClickListener(){

        }
    }
}