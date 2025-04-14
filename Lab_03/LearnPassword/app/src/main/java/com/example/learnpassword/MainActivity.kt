package com.example.learnpassword

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var buttonRegister: Button
    private lateinit var buttonLogin: Button
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupViews()
        buttonRegister.setOnClickListener(this)
        buttonLogin.setOnClickListener(this)
    }

    private fun setupViews() {
        buttonRegister = findViewById(R.id.btn_register)
        buttonLogin = findViewById(R.id.btn_login)
        editTextEmail = findViewById(R.id.editText_email)
        editTextPassword = findViewById(R.id.edit_password)
        editTextPassword.transformationMethod = PasswordMaskTransformation()
    }

    @SuppressLint("StringFormatInvalid")
    override fun onClick(p0: View?) {
        p0?.let {
            when (it.id) {
                R.id.btn_register -> {
                    if(editTextEmail.text.isNotBlank() && editTextPassword.text.isNotBlank())
                        Toast.makeText(this, getString(R.string.register_success, editTextEmail.text), Toast.LENGTH_LONG).show()
                    else
                        Toast.makeText(this, getString(R.string.register_fail), Toast.LENGTH_LONG).show()
                }

                R.id.btn_login -> {
                    val user = user(editTextEmail.text.toString(), editTextPassword.text.toString())
                    if(user == defaultUser)
                        Toast.makeText(this, getString(R.string.login_success, editTextEmail.text), Toast.LENGTH_LONG).show()
                    else
                        Toast.makeText(this, getString(R.string.login_fail), Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    companion object {
        val defaultUser = user("admin@gmail.com", "123456")
    }

}