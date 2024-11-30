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
import com.google.android.material.snackbar.Snackbar
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

        var tip: String = "0"
        var total: Float = 0.0f

        binding.tipPercentage0.setOnCheckedChangeListener {_, isChecked ->
            if (isChecked) {
                tip = "0"
            }
        }
        binding.tipPercentage10.setOnCheckedChangeListener {_, isChecked ->
            if (isChecked) {
                tip = "10"
            }
        }
        binding.tipPercentage20.setOnCheckedChangeListener {_, isChecked ->
            if (isChecked) {
                tip = "20"
            }
        }
        binding.tipPercentage25.setOnCheckedChangeListener {_, isChecked ->
            if (isChecked) {
                tip = "25"
            }
        }
        binding.tipPercentage30.setOnCheckedChangeListener {_, isChecked ->
            if (isChecked) {
                tip = "30"
            }
        }


        binding.calculateButton.setOnClickListener {

                total = calculateValues(binding.accountInput, binding.numberOfPeopleInput, tip).toFloat()

            println(total)

        }

        binding.limpar.setOnClickListener {
            binding.accountInput.text?.clear()
            binding.numberOfPeopleInput.text?.clear()
            binding.tipPercentage.clearCheck()
        }

    }

    private fun calculateValues(accountInput: TextInputEditText, numberOfPeople: TextInputEditText, tip: String): String {
        if (accountInput.text.isNullOrBlank() || numberOfPeople.text.isNullOrBlank() || tip.isEmpty()) {
            Snackbar.make(binding.accountInput,"Insert all the values.", Snackbar.LENGTH_LONG).show()
            return "0.0";
        }
        return ((accountInput.text.toString().toDouble() / numberOfPeople.text.toString().toDouble())*(1+tip.toDouble()/100)).toString()

    }


}