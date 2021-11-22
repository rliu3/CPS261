package com.example.recycleviewintents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import com.example.recycleviewintents.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return

        val title = extras.getString("title")
        binding.textView.text = title
        val detail = extras.getString("details")
        binding.textView2.text = detail
        val image = extras.getInt("image")
        binding.imageView.setImageResource(image)
    }


}