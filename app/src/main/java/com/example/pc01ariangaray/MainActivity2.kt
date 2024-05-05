package com.example.pc01ariangaray

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val Resultado= findViewById<TextView>(R.id.resultado)
        val NotalFinal= findViewById<TextView>(R.id.notaFinal)

        val notalFinal = intent.getStringExtra("notaFinal")
        val resultado = intent.getStringExtra("resultado")

        NotalFinal.text = notalFinal.toString();
        Resultado.text = resultado.toString();
    }

}