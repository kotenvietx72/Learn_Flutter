package com.example.learnedittext

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
        val text_Messeage = findViewById<TextView>(R.id.txt_Messeage)
        val YourName = findViewById<EditText>(R.id.eT_YourName)
        val Ex = findViewById<EditText>(R.id.eT_Ex)
        val BirthDate = findViewById<EditText>(R.id.eT_BirthDate)
        val btn_result = findViewById<Button>(R.id.btn_result)
        btn_result.setOnClickListener {
            text_Messeage.text = YourName.text.toString()
            YourName.text.clear()
            Ex.text.clear()
            BirthDate.text.clear()
        }
    }
}