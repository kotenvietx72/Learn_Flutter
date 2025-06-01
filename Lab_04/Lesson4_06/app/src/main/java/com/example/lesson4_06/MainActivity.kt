package com.example.lesson4_06

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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

        // Khỏi chạy tưởng minh
        val btnStartNewActivity = findViewById<Button>(R.id.btn_Start_Activity)
        btnStartNewActivity.setOnClickListener {
            val name = "Nguyễn Việt Anh"
            val age = 21
            val exName = arrayOf("Trang", "Em", "Linh", "Hoa")

            val myIntent = Intent(this, InformationActivity::class.java)
//            .apply {
//                putExtra(InformationActivity.EXTRA_NAME, name)
//                putExtra(InformationActivity.EXTRA_AGE, age)
//                putExtra(InformationActivity.EXTRA_EX_NAME, exName)
//                startActivity(this)
//            }
            myIntent.putExtra(InformationActivity.EXTRA_NAME, name)
            myIntent.putExtra(InformationActivity.EXTRA_AGE, age)
            myIntent.putExtra(InformationActivity.EXTRA_EX_NAME, exName)
            startActivity(myIntent)
        }

        // Khởi chạy ngầm định
//        val btnStartNewActivity = findViewById<Button>(R.id.btn_Start_Activity)
//        btnStartNewActivity.setOnClickListener {
//                val myIntent = Intent().apply {
//                    action = Intent.ACTION_VIEW
//                    addCategory(Intent.CATEGORY_DEFAULT)
//                }
//                startActivity(myIntent)
//        }


    }
}