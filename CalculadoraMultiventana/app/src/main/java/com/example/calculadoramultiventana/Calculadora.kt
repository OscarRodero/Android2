package com.example.calculadoramultiventana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadoramultiventana.databinding.ActivityCalculadoraBinding

class Calculadora : AppCompatActivity() {
    lateinit var binding: ActivityCalculadoraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_calculadora)
        binding = ActivityCalculadoraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Boton sumar
        binding.bntSumar.setOnClickListener(){
            var resul:Double = binding.edtNumero1.text.toString().toDouble()+binding.edtNumero2.text.toString().toDouble()
            lanzarResultado(resul)
        }
        //Boton Restar
        binding.btnRestar.setOnClickListener(){
            var resul:Double = binding.edtNumero1.text.toString().toDouble()-binding.edtNumero2.text.toString().toDouble()
            lanzarResultado(resul)
        }
        //Boton Multiplicar
        binding.btnMultiplicar.setOnClickListener(){
            var resul:Double = binding.edtNumero1.text.toString().toDouble()*binding.edtNumero2.text.toString().toDouble()
            lanzarResultado(resul)
        }
        //Boton Dividir
        binding.btnDividir.setOnClickListener(){
            if(binding.edtNumero2.text.toString().toDouble()!=0.0) {
                var resul: Double = binding.edtNumero1.text.toString().toDouble() / binding.edtNumero2.text.toString().toDouble()
                lanzarResultado(resul)
            }else{
                var resul:String="No se puede dividir entre 0"
                intent = Intent(this, Resultado::class.java)
                intent.putExtra("resultado", resul)
                startActivity(intent)
            }
        }
    }

    private fun lanzarResultado(resul: Double) {
        intent = Intent(this, Resultado::class.java)
        intent.putExtra("resultado", resul)
        startActivity(intent)
    }
}