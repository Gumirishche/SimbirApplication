package com.example.simbirapplication

class Day(val day:Int,val month:Int, val year:Int,var cases:MutableList<String>) {
    fun addCase(case:String){
        cases.add(case);
    }
    @JvmName("getCases1")
    fun getCases():MutableList<String>{
        return cases
    }
    fun getDate():String{
        return "$day/$month/$year"
    }
}