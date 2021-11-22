package com.example.recycleviewintents

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    companion object{
        var intlist: ArrayList<ArrayList<Int>> = arrayListOf()
    }
    fun generator():ArrayList<ArrayList<Int>>{
        if(intlist.size==0){
            val n = 7
            var i = 0
            while (i<=n){
                intlist.add(arrayListOf((0..7).random(),(0..7).random(),(0..7).random()))
                i++
            }
        }
        return intlist
    }
}