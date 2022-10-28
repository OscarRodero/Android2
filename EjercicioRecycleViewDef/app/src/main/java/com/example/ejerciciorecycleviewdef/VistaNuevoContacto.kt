package com.example.ejerciciorecycleviewdef

import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejerciciorecycleviewdef.databinding.ActivityVistaNuevoContactoBinding


class VistaNuevoContacto : AppCompatActivity() {
    lateinit var binding: ActivityVistaNuevoContactoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista_nuevo_contacto)
        binding.btnSeleccionarImagen.setOnClickListener{

        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            this.fotoSeleccionada=imageUri.toString()
            print(fotoSeleccionada)
        }
    }
}