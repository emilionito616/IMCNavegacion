package com.example.imcnavegacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_verde.*

class ActivityVerde : AppCompatActivity() {
    companion object{
        val EXTRA_IMC = "extraIMC"
        private  val DEFAULT_IMC: Double = -1.0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verde)
        val inten = intent
        if(inten != null && intent.hasExtra(EXTRA_IMC)){
            val imc : Double = inten.getDoubleExtra(EXTRA_IMC, DEFAULT_IMC)
            tvVerde.setText("Tu IMC= " + imc.toString() + ", y es Normal")
        }

    }
}
