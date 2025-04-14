package com.example.learn_textview

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Other)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtMessage = findViewById<TextView>(R.id.txt_Message)
        val txtIuthuong = findViewById<TextView>(R.id.txt_iuthuong)

        txtMessage.setOnClickListener(this)
        txtIuthuong.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        val xinChao = getString(R.string.xin_chao)
        val goodBye = getString(R.string.good_bye)

        if(v?.id == R.id.txt_Message) {
            val txt = v as TextView
            txt.text = if(txt.text == xinChao) goodBye else xinChao
            txt.setTextColor(Color.BLUE)
        } else if(v?.id == R.id.txt_iuthuong) {
            val txt = v as TextView
            if(txt.currentTextColor == Color.parseColor("#FF00FF")) {
                txt.setTextColor(Color.BLACK)
            } else {
                txt.setTextColor(Color.parseColor("#FF00FF"))
            }
        }
    }
}
