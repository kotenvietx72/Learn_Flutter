package com.example.learnimageview2

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var textEmail: EditText
    private lateinit var textPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button
    private lateinit var imgShowPassword: ImageView
    private lateinit var transformation: PasswordMaskTransformation

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
        transformation = PasswordMaskTransformation()
        textPassword.transformationMethod = transformation
    }

    private fun setupViews() {
        textEmail = findViewById(R.id.edit_email)
        textPassword = findViewById(R.id.edit_password)
        btnLogin = findViewById(R.id.btn_login)
        btnRegister = findViewById(R.id.btn_register)
        imgShowPassword = findViewById(R.id.img_show_password)
        imgShowPassword.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        processShowPassword()
    }

    private fun processShowPassword() {
        if(textPassword.transformationMethod == transformation) {
            textPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            imgShowPassword.setImageResource(R.drawable.ic_hide_password)
        } else {
            textPassword.transformationMethod = transformation
            imgShowPassword.setImageResource(R.drawable.ic_show_passwprd)
        }
    }
}