package com.example.imcnavegacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var pes : Int = 0
    var alt : Double = 0.0
    var imc : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun CalcularIMC(v: View){
        if(etPeso.text.isEmpty()){
            Toast.makeText(this, "Falta peso en Kg", Toast.LENGTH_LONG).show()
            etPeso.requestFocus()
        }else if(etAltura.text.isEmpty()){
            Toast.makeText(this, "Falta altura en mts", Toast.LENGTH_LONG).show()
            etAltura.requestFocus()
        }
        else{
            pes = etPeso.text.toString().toInt()
            alt = etAltura.text.toString().toDouble()
            imc = pes/(alt*alt)
            var res=""
            when {
                imc<25 ->{
                    val inten= Intent(this,ActivityVerde::class.java)
                    inten.putExtra(ActivityVerde.EXTRA_IMC, imc)
                    startActivity(inten)
                }
                imc>=25&&imc<30 -> {
                    val inten= Intent(this,ActivityAmarillo::class.java)
                    inten.putExtra(ActivityAmarillo.EXTRA_IMC, imc)
                    startActivity(inten)
                }
                imc>=30 -> {
                    val inten= Intent(this,ActivityRojo::class.java)
                    inten.putExtra(ActivityRojo.EXTRA_IMC, imc)
                    startActivity(inten)
                }
            }
        }
    }
}
