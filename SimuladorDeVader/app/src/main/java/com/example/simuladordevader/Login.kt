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
    lateinit var inte:Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAcceder.setOnClickListener(){
            if(!binding.etxtNombreLogin.text.toString().equals("") && !binding.etxtContraseA.text.toString().equals("")) {
                var p = Conexion.Conexion.conectar(this, binding.etxtNombreLogin.text.toString())
                if(p!=null){
                    if(p.password.equals(binding.etxtContraseA.text.toString())){
                        if(p.name.equals("Vader")){
                            inte = Intent(this, MainActivity::class.java)
                            inte.putExtra("nombre", binding.etxtNombreLogin.text.toString())
                            startActivity(inte)
                        }else{
                            inte = Intent(this, PrincipalPilotos::class.java)
                            startActivity(inte)
                        }
                    }
                }
            }
        }
        binding.btnSalir.setOnClickListener(){
            finish()
        }
    }
}