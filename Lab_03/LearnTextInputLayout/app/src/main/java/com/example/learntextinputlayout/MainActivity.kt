package com.example.learntextinputlayout

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var editTextEmail: TextInputEditText
    private lateinit var editTextPassword: TextInputEditText
    private lateinit var editTextConfirmPassword: TextInputLayout
    private lateinit var buttonLogin: Button

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

        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            val messeage = "Welcome $email\nYour Password: $password"

            Snackbar.make(it, messeage, Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun setupViews() {
        editTextEmail = findViewById(R.id.editText_email)
        editTextPassword = findViewById(R.id.editText_Password)
        buttonLogin = findViewById(R.id.btn_login)
        editTextConfirmPassword = findViewById(R.id.edit_password)

        editTextPassword.transformationMethod = PasswordMask.getInstance()
        editTextConfirmPassword.addEndIconOnClickListener()
    }
}