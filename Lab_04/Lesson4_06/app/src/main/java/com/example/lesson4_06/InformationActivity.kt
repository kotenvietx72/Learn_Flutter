package com.example.lesson4_06

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InformationActivity : AppCompatActivity() {
    private lateinit var edt_fullName: EditText
    private lateinit var edt_age: EditText
    private lateinit var edt_exName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_information)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        edt_fullName = findViewById(R.id.txt__fullName)
        edt_age = findViewById(R.id.txt_age)
        edt_exName = findViewById(R.id.txt__exName)

        fillData()
    }

    private fun fillData() {
        val fullName = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)
        val exName = intent.getStringArrayExtra(EXTRA_EX_NAME)

        val exNames = StringBuilder()
        if(exName != null) {
            for (name in exName) {
                exNames.append(name).append(", ")
            }
        }

        edt_fullName.setText(fullName)
        edt_age.setText(age.toString())
        edt_exName.setText(exNames)
    }

    companion object {
        const val EXTRA_NAME = "com.example.lesson4_06.EXTRA_NAME"
        const val EXTRA_AGE = "com.example.lesson4_06.EXTRA_AGE"
        const val EXTRA_EX_NAME = "com.example.lesson4_06.EXTRA_EX_NAME"
    }
}