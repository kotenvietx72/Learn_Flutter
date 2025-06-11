package com.example.lesson4_07_startactivityforresult

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class InformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_information)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSubmit = findViewById<Button>(R.id.btn_submit)
        btnSubmit.setOnClickListener {
            submitInformation()
        }

    }
    private fun submitInformation(){
        val edtFullName = findViewById<TextInputEditText>(R.id.edt_fullName)
        val edtSalary = findViewById<TextInputEditText>(R.id.edt_salary)

        val fullName = edtFullName.text
        val salary = edtSalary.text

        val intent = Intent().apply {
            putExtra(MainActivity.EXTRA_FULLNAME, fullName)
            putExtra(MainActivity.EXTRA_SALARY, salary)
        }

        setResult(RESULT_OK, intent)
        finish()
    }
}