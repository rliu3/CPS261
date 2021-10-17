package com.example.addnamesavedata.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var list = ""
    fun setName(person: String){
        list += person+"\n"
    }

    fun getNames(): String {
        return if (list.isNotEmpty()){
            list
        } else{
            "No names to display"
        }
    }
}