package com.example.simbirapplication

class Day(val day:Int,val month:Int, val year:Int,val case:String) {
    @JvmName("getCases1")
    fun getCases():String{
        return case
    }
    fun getDate():String{
        return "$day/$month/$year"
    }
}