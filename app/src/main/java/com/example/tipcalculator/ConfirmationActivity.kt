package com.example.tipcalculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipcalculator.databinding.ActivityConfirmationBinding
import com.example.tipcalculator.databinding.ActivityMainBinding

class ConfirmationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConfirmationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val accountValue: String? = intent.getStringExtra(ACCOUNT_VALUE)
        val numberPeople: String? = intent.getStringExtra(NUMBER_PEOPLE)
        val tipPercentage: String? = intent.getStringExtra(PERCENTAGE_TIP)
        val result: Float = intent.getFloatExtra("result", 0.0f)

        binding.account.text = "${accountValue} €"
        binding.numberOfPeople.text = numberPeople
        binding.tipPercentage.text = "${tipPercentage} %"
        binding.total.text = "€ ${result}"

        binding.calculateButton.setOnClickListener {
            val exInt = Intent(this, MainActivity::class.java)
            startActivity(exInt)
        }

        binding.limpar.setOnClickListener {
            finish() // close current screen
        }

    }


}