package com.example.feng.tipcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    lateinit var costInput: EditText
    lateinit var tipInput: Spinner
    lateinit var tipButton: Button

    var cost = 0.0
    var tipRate = 0.0
    var totalTip = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        costInput = findViewById(R.id.cost_input)
        tipInput = findViewById(R.id.percent_select)
        tipButton = findViewById(R.id.screenchange_button)

        tipButton.setOnClickListener {
            if (checkData()) {
                //Getting text from user
                cost = costInput.text.toString().toDouble()
                val tipPercent = tipInput.selectedItem.toString()
                if(tipPercent == "5%")
                    tipRate = 0.05
                if(tipPercent == "10%")
                    tipRate = 0.1
                if(tipPercent == "15%")
                    tipRate = 0.15
                if(tipPercent == "20%")
                    tipRate = 0.2
                if(tipPercent == "25%")
                    tipRate = 0.25
                totalTip = tipRate * cost

                //Format the total charges for money
                val currency = DecimalFormat("$##,###.00")
                val tipFormatted = currency.format(totalTip)
                val costFormatted = currency.format(cost)

                val result = "Total tip for a meal that costs $costFormatted at a $tipPercent rate is $tipFormatted"

                Intent(this@MainActivity, ResultsScreen::class.java).also {
                    it.putExtra("EXTRA_RESULT", result)
                    startActivity(it)
                }
            }
        }

    }

    private fun checkData(): Boolean {

        if (costInput.text.toString().isEmpty()){
            costInput.error = "Cost cannot be empty"
            costInput.requestFocus()
            return false
        }
        return true

    }
}