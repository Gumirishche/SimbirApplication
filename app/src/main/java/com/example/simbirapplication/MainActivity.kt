package com.example.simbirapplication

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextPaint
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.util.Calendar


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var casesDate:MutableList<Int>
        var caseDay:Day

        var x:String = "4"

        val c= Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val date:Button =findViewById(R.id.buttonDate)
        val input:EditText = findViewById(R.id.textCase)
        val output:TextView = findViewById(R.id.caseText)
        date.setOnClickListener {
            val dpd = DatePickerDialog(this, { _, mYear, mMonth, mDayOfMonth ->
                date.text = ""+ mDayOfMonth+"/"+(mMonth+1)+"/"+mYear
            },year,month,day)
            dpd.show()
        }
        val adder: Button = findViewById(R.id.buttonAdd)
        adder.setOnClickListener{
            caseDay = Day(day,month,year,input.text.toString())
            output.text = caseDay.getCases()
        }
    }
}