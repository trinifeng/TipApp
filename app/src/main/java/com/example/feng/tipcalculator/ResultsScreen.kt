package com.example.feng.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultsScreen : AppCompatActivity() {

    lateinit var resultOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results_screen)

        resultOutput = findViewById(R.id.result_output)

        val result = intent.getStringExtra("EXTRA_RESULT")

        resultOutput.text = result
    }
}