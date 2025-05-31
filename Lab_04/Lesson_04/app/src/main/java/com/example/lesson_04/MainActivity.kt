package com.example.lesson_04

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private var isRecreated = false
    private lateinit var edtFullName: TextInputEditText
    private lateinit var edtGpa: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setUpViews()
        if(!isRecreated) {
            val gpa = 3.55f
            val fullName = "Nguyen Viet Anh"

            edtGpa.setText(gpa.toString())
            edtFullName.setText(fullName)
        }

        isRecreated = savedInstanceState != null
    }

    private fun setUpViews() {
        edtFullName = findViewById(R.id.edt__fullName)
        edtGpa = findViewById(R.id.edt_gpa)
    }

    // Mục đích lưu và khôi phục trạng thái: Để đảm bảo giá trị đang tương tác, khi thay đổi cấu hình (Xoay màn hình, nhận cuộc gọi) thì không bị mất

    // Khi xoay màn hình hoặc thoát màn hình, lưu lại các giá trị trong ô nhập
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val gpa = 3.77f
        val fullName = "Nguyễn Việt Anh"

        outState.putFloat(STATE_GPA, gpa)
        outState.putString(STATE_FULLNAME, fullName)
    }

    // Khôi phục các giá trị đã lưu ở trên
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val fullName = savedInstanceState.getString(STATE_FULLNAME)
        val gpa = savedInstanceState.getFloat(STATE_GPA, 0f)

        edtGpa.setText(gpa.toString())
        edtFullName.setText(fullName)
    }

    companion object{
        const val STATE_FULLNAME = "com.example.lesson_04.STATE_FULLNAME"
        const val STATE_GPA = "com.example.lesson_04.STATE_GPA"
    }
}