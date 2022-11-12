package com.example.simuladordevader

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.simuladordevader.databinding.ActivityAltaNavesBinding
import com.example.simuladordevader.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAcceder.setOnClickListener(){
            if(!binding.etxtNombreLogin.text.toString().equals("") && !binding.etxtContraseA.text.toString().equals("")){
                val intent = Intent()
                intent.putExtra("QuienLoggea", binding.etxtNombreLogin.text.toString())
                intent.putExtra("Contraseña", binding.etxtContraseA.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }else if(binding.etxtNombreLogin.text.toString().equals("")){
                Toast.makeText(this,"El campo del nombre no puede estar vacío",Toast.LENGTH_SHORT)
            }else if(binding.etxtContraseA.text.toString().equals("")){
                Toast.makeText(this,"El campo de la contraseña no puede estar vacío",Toast.LENGTH_SHORT)
            }else{
                Toast.makeText(this,"No puede haber campos vacíos.",Toast.LENGTH_SHORT)
            }
        }
        binding.btnCancelar.setOnClickListener(){
            val intent = Intent()
            setResult(Activity.RESULT_CANCELED, intent)
            finish()
        }
    }
}