package com.example.learnbutton

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var buttonRegister: Button
    private lateinit var buttonReset: Button
    private lateinit var fullNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var addressEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        buttonRegister = findViewById(R.id.btn_register)
        buttonReset = findViewById(R.id.btn_reset)
        initViews()


        // Bắt sự kiện cho nút bấm Cách 1
        buttonRegister.setOnClickListener {
            if (fullNameEditText.text.isBlank() || emailEditText.text.isBlank() || addressEditText.text.isBlank()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val user = createUser()
            Toast.makeText(this, "User: $user", Toast.LENGTH_SHORT).show()
            clearText()
        }

        buttonReset.setOnClickListener {
            clearText()
        }
    }

    private fun initViews() {
        fullNameEditText = findViewById(R.id.edit_fullname)
        emailEditText = findViewById(R.id.edit_email)
        addressEditText = findViewById(R.id.edit_address)
    }

    private fun clearText() {
        fullNameEditText.text.clear()
        emailEditText.text.clear()
        addressEditText.text.clear()
    }

    private fun createUser(): user {
        val fullName = fullNameEditText.text.toString()
        val email = emailEditText.text.toString()
        val address = addressEditText.text.toString()
        return user(fullName, email, address)
    }
}