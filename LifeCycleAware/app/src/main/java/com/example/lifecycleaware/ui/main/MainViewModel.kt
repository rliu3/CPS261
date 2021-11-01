package com.example.lifecycleaware.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var list: MutableLiveData<String> = MutableLiveData("")
    fun setState(state: String) {
        list.value += state + "\n"
    }
}