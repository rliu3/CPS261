package com.example.recycleview

import androidx.lifecycle.MutableLiveData
import com.example.recycleview.Data.Companion.details
import java.util.*
import kotlin.collections.ArrayList


class Data {
    companion object {

        private val titles = arrayOf(
            "Chapter One",
            "Chapter Two", "Chapter Three", "Chapter Four",
            "Chapter Five", "Chapter Six", "Chapter Seven",
            "Chapter Eight"
        )

        private val details = arrayOf(
            "Item one details", "Item two details",
            "Item three details", "Item four details",
            "Item five details", "Item six details",
            "Item seven details", "Item eight details"
        )

        private val images = intArrayOf(
            R.drawable.android_image_1,
            R.drawable.android_image_2, R.drawable.android_image_3,
            R.drawable.android_image_4, R.drawable.android_image_5,
            R.drawable.android_image_6, R.drawable.android_image_7,
            R.drawable.android_image_8
        )
        fun getDetails(i:Int): String {
            return details[i]
        }
        fun getTitles(i:Int): String {
            return titles[i]
        }
        fun getImages(i:Int): Int {
            return images[i]
        }
        fun shuffle(){
            details.shuffle()
            images.shuffle()
            titles.shuffle()
        }
    }
}