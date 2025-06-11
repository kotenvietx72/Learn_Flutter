package com.example.lesson4_07_startactivityforresult

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var observer: GetInforObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnStartNewActivity = findViewById<Button>(R.id.btn_start_New_Activity)
        observer = GetInforObserver(activityResultRegistry, this)
        lifecycle.addObserver(observer)

        btnStartNewActivity.setOnClickListener{
//            Intent(this, InformationActivity::class.java).apply {
////              startActivityForResult(this, REQUEST_CODE)
//
//            }
            observer.launchActivity()
        }


    }

    fun handleResult(result: ActivityResult) {
        val data = result.data
        data?.let{
            val salary = data.getStringExtra(EXTRA_SALARY)
            val fullName = data.getStringExtra(EXTRA_FULLNAME)

            findViewById<TextView>(R.id.txt_fullName).setText(fullName)
            findViewById<TextView>(R.id.txt_salary).setText(salary)
        }

    }

//    @SuppressLint("SetTextI18n")
//    @Deprecated("This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      with the appropriate {@link ActivityResultContract} and handling the result in the\n      {@link ActivityResultCallback#onActivityResult(Object) callback}.")
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if(data != null && resultCode == RESULT_OK && requestCode == REQUEST_CODE){
//
//            val salary = data.getStringExtra(EXTRA_SALARY)
//            val fullName = data.getStringExtra(EXTRA_FULLNAME)
//
//            findViewById<TextView>(R.id.txt_fullName).text = "Họ tên: $fullName"
//            findViewById<TextView>(R.id.txt_salary).text = "Mức lương: $salary"
//        }
//    }

    companion object{
        const val EXTRA_FULLNAME = "com.example.lesson4_07_startactivityforresult.EXTRA_FULLNAME"
        const val EXTRA_SALARY = "com.example.lesson4_07_startactivityforresult.EXTRA_SALARY"
        //const val REQUEST_CODE = 1000
    }
}