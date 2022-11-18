package com.example.simuladordevader

import Adaptadores.AdaptadorMisiones
import Conexion.Conexion
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simuladordevader.databinding.ActivityPrincipalPilotosBinding

class PrincipalPilotos : AppCompatActivity() {
    private val cameraRequest = 1888
    lateinit var binding: ActivityPrincipalPilotosBinding
    lateinit var miRV:RecyclerView
    lateinit var miRVT:RecyclerView
    lateinit var inte:Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //(setContentView(R.layout.activity_principal_pilotos)
        binding = ActivityPrincipalPilotosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.CAMERA)==PackageManager.PERMISSION_DENIED)
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), cameraRequest)

        binding.btnEditarImagen.setOnClickListener(){
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, cameraRequest)
        }

        binding.txtNombreStoormTrooper.setText(intent.getStringExtra("nombre"))
        binding.txtTotalExperiencia.setText(intent.getStringExtra("experiencia"))

        binding.btnEditarImagen.setOnClickListener(){
            binding.imagenPerfil.setImageResource(seleccionarImagen())
        }

        miRV = binding.rvMisiones as RecyclerView
        miRV.setHasFixedSize(true)
        miRV.layoutManager = LinearLayoutManager(this)
        var miAdaptadorPilotos = AdaptadorMisiones(Conexion.obtenerMisionesPendientes(this, R.id.etxtNombreLogin.toString()), this)
        miRV.adapter=miAdaptadorPilotos

        miRVT = binding.rvMisiones as RecyclerView
        miRVT.setHasFixedSize(true)
        miRVT.layoutManager = LinearLayoutManager(this)
        var miAdaptadorPilotos2= AdaptadorMisiones(Conexion.obtenerMisionesPendientes(this, R.id.etxtNombreLogin.toString()), this)
        miRVT.adapter=miAdaptadorPilotos2
        miRVT.isVisible=false

        binding.switchMisiones.setOnCheckedChangeListener{ buttonView, isChecked ->
            if(isChecked){
                binding.switchMisiones.setText("Todas las Misiones")
                cambiarRecycleView(1)
            }else{
                binding.switchMisiones.setText("Misiones Pendientes")
                cambiarRecycleView(0)
            }
        }

        binding.btnEditarImagen.setOnClickListener(){
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, cameraRequest)
        }
    }
    override fun onActivityResult(requestCode:Int, resultCode:Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == cameraRequest){
            val photo: Bitmap = data?.extras?.get("data") as Bitmap
            binding.imagenPerfil.setImageBitmap(photo)
        }
    }
    private fun seleccionarImagen(): Int {
        return 0
    }

    private fun cambiarRecycleView(i: Int) {
        if(i==0){
            miRV.isVisible=true
            miRVT.isVisible=false
        }else{
            miRV.isVisible=false
            miRVT.isVisible=true
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

    private fun abrirAjustes() {
        inte = Intent(this, Ajustes::class.java)
        startActivity(inte)
    }
}