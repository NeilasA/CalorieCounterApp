package com.example.CalorieCalculatorApp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import com.example.CalorieCalculatorApp.Model.MaxDailyCalorieIntake
import com.example.CalorieCalculatorApp.Model.ModelMaxDailyCalorieIntake
import com.google.android.gms.tasks.OnCompleteListener
import kotlinx.android.synthetic.main.fragment_caloriecalculator.*
import android.widget.ArrayAdapter as ArrayAdapter1

class CalorieCalculator : AppCompatActivity() {

    var gender = ""
    var activityLevelPosition = ""
    var activityLevel = ""

    lateinit var option: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_calorie_intake)

        ModelMaxDailyCalorieIntake

        dailyCalorieIntakeTextView.text = ""
        val maxDailyCalories = dailyCalorieIntakeTextView.text.toString()


        calculateButton.setOnClickListener {
            calculateDailyCalories()
            saveMaxDailyCalorieIntake()
            Log.d("Data","Data was send")

            val intent = Intent (this, MainActivity::class.java)
            intent.putExtra("MaxDailyCalories", maxDailyCalories)
            startActivity(intent)

            if (dailyCalorieIntakeTextView.text != "") {
                ageEditText.text = null
                heightEditText.text = null
                weightEditText.text = null
                womenToggleButton.isChecked = false
                manToggleButton.isChecked = false
            }
        }

        option = this.findViewById(R.id.mySpinner)

        val myString = arrayOf(
            "Base Metabolic Rate(BRM)",
            "Little to no exercise",
            "Light exercise (1–3 days per week)",
            "Moderate exercise (3–5 days per week)",
            "Heavy exercise (6–7 days per week)",
            "Very heavy exercise (twice per day, extra heavy workouts)"
        )
        option.adapter =
            ArrayAdapter1<String>(this, android.R.layout.simple_expandable_list_item_1, myString)

        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                activityLevelPosition = mySpinner.getItemIdAtPosition(p2).toString()
                getActivityLevelPosition()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
    }

    fun onClickedManButton(view: View) {
        womenToggleButton.isChecked = false
        gender = "man"
        dailyCalorieIntakeTextView.text = null
    }

    fun onClickedWomenButton(view: View) {
        manToggleButton.isChecked = false
        gender = "women"
        dailyCalorieIntakeTextView.text = null
    }


    private fun getActivityLevelPosition() {
        when (activityLevelPosition) {
            "0" -> activityLevel = 1.toString()
            "1" -> activityLevel = 1.2f.toString()
            "2" -> activityLevel = 1.375f.toString()
            "3" -> activityLevel = 1.55f.toString()
            "4" -> activityLevel = 1.725f.toString()
            "5" -> activityLevel = 1.9f.toString()

            else -> Toast.makeText(this, "Chose your activity level", LENGTH_LONG).show()
        }
    }

    private fun calculateDailyCalories() = when (gender) {
        "man" -> dailyCalorieIntakeTextView.text =
            (((66.47430f + (13.7516f * Integer.parseInt(weightEditText.text.toString())) +
                    (5.0033f * Integer.parseInt(heightEditText.text.toString())) - (6.7550f * Integer.parseInt(ageEditText.text.toString()))) * (activityLevel.toFloat())).toString())

        "women" -> dailyCalorieIntakeTextView.text =
            (((655.0955f + (9.5634f * Integer.parseInt(weightEditText.text.toString())) +
                    (1.8496f * Integer.parseInt(heightEditText.text.toString())) - (4.6756f * Integer.parseInt(ageEditText.text.toString()))) * (activityLevel.toFloat())).toString())


        else -> Toast.makeText(this, "Chose your gender", LENGTH_LONG).show()
    }

    private fun saveMaxDailyCalorieIntake(){
        if (dailyCalorieIntakeTextView.text == null) {
            return
        }
        val maxDailyCalorieIntake = MaxDailyCalorieIntake(null)
        maxDailyCalorieIntake.maxDailyCalorieIntake = dailyCalorieIntakeTextView.text.toString()

        ModelMaxDailyCalorieIntake.saveMaxDailyCalorieIntake(maxDailyCalorieIntake, OnCompleteListener { task ->
            if(task.isCanceled) {
                finish()
            }
        })
    }
}

