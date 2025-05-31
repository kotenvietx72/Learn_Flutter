package com.example.bt4_04

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var edtNguoiChoi: TextView
    private lateinit var edtLevel:TextView
    private lateinit var edtDiem:TextView
    private lateinit var edtSucManh:TextView

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
    }

    private fun setUpViews() {
        edtNguoiChoi = findViewById(R.id.edt_nguoiChoi)
        edtLevel = findViewById(R.id.edt_Level)
        edtDiem = findViewById(R.id.edt_Diem)
        edtSucManh = findViewById(R.id.edt_sucManh)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val nguoiChoi = "Người chơi: Linh xinh gái"
        val level = "Level: 30"
        val diem = "Điểm: 99"
        val sucManh = "Sức mạnh: 980"

        outState.putString(STATE_NGUOICHOI, nguoiChoi)
        outState.putString(STATE_LEVEL, level)
        outState.putString(STATE_DIEM, diem)
        outState.putString(STATE_SUCMANH, sucManh)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val nguoiChoi = savedInstanceState.getString(STATE_NGUOICHOI)
        val level = savedInstanceState.getString(STATE_LEVEL)
        val diem = savedInstanceState.getString(STATE_DIEM)
        val sucManh = savedInstanceState.getString(STATE_SUCMANH)

        edtNguoiChoi.text = nguoiChoi
        edtLevel.text = level
        edtDiem.text = diem
        edtSucManh.text = sucManh
    }

    companion object {
        const val STATE_NGUOICHOI = "com.example.bt4_04.STATE_NGUOICHOI"
        const val STATE_LEVEL = "com.example.bt4_04.STATE_LEVEL"
        const val STATE_DIEM = "com.example.bt4_04.STATE_DIEM"
        const val STATE_SUCMANH = "com.example.bt4_04.STATE_SUCMANH"
    }
}