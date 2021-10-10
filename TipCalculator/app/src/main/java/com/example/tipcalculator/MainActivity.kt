package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tipBtn.setOnClickListener {
            if (binding.billAmount.text.isNullOrEmpty() ){
                binding.output.text = "YOU MUST ENTER A BILL AMOUNT"
                return@setOnClickListener
            }

            val input = binding.billAmount.text.toString().toDouble()
            val tip10 = round((input*.10)+input)
            val tip15 = round((input*.15)+input)
            val tip20 = round((input*.20)+input)

            binding.output.text =
                "The tips are as follows: \n" +
                        "\n10% = " + tip10 + "\n15% = " + tip15  + "\n20% = " + tip20
        }
    }

    private fun round(number: Double): String? {
        val df = DecimalFormat("0.00")
        df.roundingMode = RoundingMode.CEILING
        return df.format(number)
    }
}