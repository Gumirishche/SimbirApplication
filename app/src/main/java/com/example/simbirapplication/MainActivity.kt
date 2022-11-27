package com.example.simbirapplication

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.Calendar


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var casesDate:MutableList<Int>
        var cases:MutableList<String>

        val c= Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val date:Button =findViewById(R.id.buttonDate)
        date.setOnClickListener {
            val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { _, mYear, mMonth, mDayOfMonth ->
                date.text = ""+ mDayOfMonth+"/"+(mMonth+1)+"/"+mYear
            },year,month,day)
            dpd.show()
        }

    }
}