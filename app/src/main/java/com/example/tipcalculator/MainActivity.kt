package com.example.tipcalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipcalculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val ACCOUNT_VALUE = "account_value"
const val NUMBER_PEOPLE = "number_people"
const val PERCENTAGE_TIP = "percentage_tip"

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

        var tip: String = ""
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

        val spinner: Spinner = binding.numberOfPeople
        ArrayAdapter.createFromResource(
            this,
            R.array.number_people,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            spinner.adapter = adapter
        }


        var numberOfPeopleSelected: Int = 0
        binding.numberOfPeople.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
                    // An item is selected. You can retrieve the selected item using
                    numberOfPeopleSelected = parent.getItemAtPosition(pos).toString().toInt()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Another interface callback.
                }



        }


        binding.calculateButton.setOnClickListener {
            total = calculateValues(binding.accountInput, numberOfPeopleSelected, tip).toFloat()
            println(total)
            if (total == 0.0f) {
                //binding.result.text = ""
            }
            else {
                val externalIntent = Intent(this, ConfirmationActivity::class.java)
                externalIntent.apply {
                    putExtra(ACCOUNT_VALUE, binding.accountInput.text.toString())
                    putExtra(NUMBER_PEOPLE, numberOfPeopleSelected.toString())
                    putExtra(PERCENTAGE_TIP, tip)
                    putExtra("result", total)
                }
                startActivity(externalIntent)
            }

        }

        binding.limpar.setOnClickListener {
            binding.accountInput.setText("")

            binding.tipPercentage.clearCheck()
            numberOfPeopleSelected = 0
            tip = ""
            total = 0.0f
            //binding.result.text = ""
        }

    }

    private fun calculateValues(accountInput: TextInputEditText, numberOfPeopleSelected: Int, tip: String): String {
        if (accountInput.text.isNullOrBlank() || tip.isEmpty()) {
            Snackbar.make(binding.accountInput,"Insert all the values.", Snackbar.LENGTH_LONG).show()
            return "0.0";
        }
        return ((accountInput.text.toString().toDouble() / numberOfPeopleSelected.toDouble())*(1+tip.toDouble()/100)).toString()

    }


}