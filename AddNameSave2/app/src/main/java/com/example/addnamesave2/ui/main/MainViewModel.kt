package com.example.addnamesave2.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {


    var person: MutableLiveData<String> = MutableLiveData()
    var result: MutableLiveData<String> = MutableLiveData("")

    fun setName() {
        if (person.value.isNullOrEmpty()){
            result.value = ""
        }
        else{
            result.value += person.value + "\n"
            person.value = ""
        }

    }
}