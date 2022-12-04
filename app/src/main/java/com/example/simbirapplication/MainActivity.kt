package com.example.simbirapplication

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val caseDay: MutableList<Day> = ArrayList()

        val c = Calendar.getInstance()
        var year = c.get(Calendar.YEAR)
        var month = c.get(Calendar.MONTH)
        var day = c.get(Calendar.DAY_OF_MONTH)
        val date: Button = findViewById(R.id.buttonDate)
        val remove: Button = findViewById(R.id.buttonRemove)
        val show: Button = findViewById(R.id.buttonShow)
        val input: EditText = findViewById(R.id.textCase)
        val output: TextView = findViewById(R.id.caseText)
        date.setOnClickListener {
            val dpd = DatePickerDialog(this, { _, mYear, mMonth, mDayOfMonth ->
                date.text = "" + mDayOfMonth + "/" + (mMonth + 1) + "/" + mYear
                output.text=""
                year = mYear
                month = mMonth
                day = mDayOfMonth
            }, year, month, day)
            dpd.show()
        }
        show.setOnClickListener {
            for (index in caseDay.indices){
                if (year == caseDay[index].year && month == caseDay[index].month && day == caseDay[index].day) {
                    output.text = caseDay[index].getCases()
                }
            }
        }
        remove.setOnClickListener {
            output.text=""
            for (index in caseDay.indices){
                if (year == caseDay[index].year && month == caseDay[index].month && day == caseDay[index].day) {
                    caseDay.removeAt(index)
                }
            }
        }
        val adder: Button = findViewById(R.id.buttonAdd)
        adder.setOnClickListener {
            caseDay.add(Day(day, month, year, input.text.toString()))
            val ind = caseDay.lastIndex
            output.text = caseDay[ind].getCases()
        }
    }
}