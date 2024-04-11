package com.example.chatbot.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

//tastatur verstecken
fun Context.hideKeyBoard(it: View) {
    try {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(it.windowToken,0)
    }catch (e:Exception){
        e.printStackTrace()
    }
}

//Toast
fun Context.longToastShow(message: String){
    Toast.makeText(this,message, Toast.LENGTH_LONG).show()

}