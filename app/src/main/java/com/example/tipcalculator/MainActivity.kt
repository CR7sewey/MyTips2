package com.example.tipcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.cursoradapter.widget.SimpleCursorAdapter.ViewBinder
import com.example.tipcalculator.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*val accountInput = findViewById<TextInputEditText>(R.id.accountInput);
        val people = findViewById<TextInputEditText>(R.id.numberOfPeopleInput);
        val radioGroup = findViewById<RadioGroup>(R.id.tipPercentage);
        val tip_0 = findViewById<RadioButton>(R.id.tipPercentage0)
        val tip_10 = findViewById<RadioButton>(R.id.tipPercentage10)
        val tip_20 = findViewById<RadioButton>(R.id.tipPercentage20)
        val tip_25 = findViewById<RadioButton>(R.id.tipPercentage25)
        val tip_30 = findViewById<RadioButton>(R.id.tipPercentage30)*/


       // val calculateButton = findViewById<Button>(R.id.calculateButton)
        // val resetButton = findViewById<Button>(R.id.limpar)


        binding.calculateButton.setOnClickListener {
            println(binding.accountInput.text)
            println(binding.numberOfPeopleInput.text)
            println(binding.tipPercentage0.isChecked)
        }

    }


}