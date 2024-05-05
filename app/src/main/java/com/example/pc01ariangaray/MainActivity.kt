package com.example.pc01ariangaray

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ExamenParcial: EditText = findViewById(R.id.ep)
        val ExamenFinal: EditText = findViewById(R.id.ef)
        val Pep: EditText = findViewById(R.id.pep)

        val btnCalcular: Button = findViewById(R.id.btnCalcular)

        btnCalcular.setOnClickListener{
            this.sendMessage(ExamenParcial.text.toString(),ExamenFinal.text.toString(),Pep.text.toString())

    }
}
    private fun sendMessage(examenParcial: String,examenFinal: String,pep: String){
        val porcientoParcial = 0.2
        val porcientoFinal = 0.2
        val porcientoPEP = 0.6

        val notaFinal =   (examenParcial.toDouble() * porcientoParcial) + (examenFinal.toDouble() * porcientoFinal) + (pep.toDouble() * porcientoPEP)

        var resultado = ""
        if (notaFinal > 10.5){
            resultado = "Aprobado"
        }else{
            resultado = "Desaprobado"
        }

        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("resultado",resultado)
        intent.putExtra("notaFinal",notaFinal.toString())
        startActivity(intent)
    }
}