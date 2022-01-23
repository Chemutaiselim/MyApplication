package com.pamela.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pamela.myapplication.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //calculate the tip
        binding.calculateButton.setOnClickListener { calculateTip() }

    }

    private fun calculateTip() {
        //Store the cost of service from edit text
        val stringInTextField = binding.costOfService.text.toString().trim()
        //.text references the text in the UI
        //convert the acquired text to double.
        if (stringInTextField.isEmpty()) {
            Toast.makeText(this, "Please Enter the cost", Toast.LENGTH_LONG).show()
        }

        val cost = stringInTextField.toDoubleOrNull()
        //Add null pointers
        if (cost == null) {
            binding.tipResult.text = ""
            return
        }
        //Show Result
        //Log.v(TAG,"THE COST{$cost}")

        //Checked Radio Button

        //assign the options to integers
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        //Show Result
        //Log.v(TAG,"THE TIP PERCENTAGE{$tipPercentage}")

        //Calculate the tip and roundup
        var tip = tipPercentage * cost
        //the switch

        //Show Result
        //Log.v(TAG,"THE TIP {$tip}")
        val roundUp = binding.roundUpSwitch.isChecked
        //if the roundUp statement is true;
        if (roundUp) {
            //The ceil function can round up the tip
            tip = ceil(tip)
            //Show Result
            //Log.v(TAG,"ROUNDED UP TIP{$tip}")
        }

        //convert to required currency
        //change the string resource, add %s

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
        //Show Result
        //Log.v(TAG,"FORMATTED TIP{$formattedTip}")
    }
}

