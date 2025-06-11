package com.example.btvn4_10

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: StaffViewModel

    private lateinit var edtId: TextInputEditText
    private lateinit var edtFullName: TextInputEditText
    private lateinit var edtBirthDate: TextInputEditText
    private lateinit var edtSalary: TextInputEditText

    private lateinit var btnAddNewStaff: Button

    private lateinit var txtResult: TextView
    private lateinit var txtAnnouncement: TextView

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
        setUpListener()
        setUpOserver()
    }

    private fun setUpViews() {
        edtId = findViewById(R.id.edt_id)
        edtFullName = findViewById(R.id.edt_full_name)
        edtBirthDate = findViewById(R.id.edt_birth_date)
        edtSalary = findViewById(R.id.edt_salary)

        btnAddNewStaff = findViewById(R.id.btn_add_new_staff)

        txtResult = findViewById(R.id.txt_result)
        txtAnnouncement = findViewById(R.id.txt_announcement)
    }

    private fun setUpListener() {
        btnAddNewStaff.setOnClickListener {
            val staffId = edtId.text.toString()
            val fullName = edtFullName.text.toString()
            val birthDate = edtBirthDate.text.toString()
            val salaryStr = edtSalary.text.toString()
            val salary = salaryStr.toFloatOrNull() ?: 0.0f


            val staff = Staff(staffId, fullName, birthDate, salary)
            viewModel.addStaff(staff)
        }

    }

    private fun setUpOserver() {
        viewModel = ViewModelProvider(this)[StaffViewModel::class.java]
        viewModel.staff.observe(this) {
            if(it.isEmpty()) {
                txtResult.text = getString(R.string.announcement_empty)
                txtAnnouncement.text = getString(R.string.announcement_empty)
            }else{
                val stringBuilder = StringBuilder()
                for(staff in it){
                    stringBuilder.append(staff.toString()).append("\n")
                }
                txtResult.text = stringBuilder.toString()
                txtAnnouncement.text = getString(R.string.announcement_result)
            }
        }
    }
}