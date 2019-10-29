package com.example.CalorieCalculatorApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.CalorieCalculatorApp.MainActivity
import com.example.CalorieCalculatorApp.R
import kotlinx.android.synthetic.main.fragment_caloriecalculator.*


class CalorieCalculatorFragment : Fragment() {

    companion object {
        fun newInstance(): CalorieCalculatorFragment {
            val f = CalorieCalculatorFragment()
            val bdl = Bundle(1)
            f.arguments = bdl
            return f

        }
    }

    var gender = ""
    var activityLevelPosition = ""
    var activityLevel = ""

    lateinit var option: Spinner
    // lateinit var  comm: Communicator


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_caloriecalculator, container, false)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        option = this.mySpinner
        val myString = arrayOf(
            "Base Metabolic Rate(BRM)",
            "Little to no exercise",
            "Light exercise (1–3 days per week)",
            "Moderate exercise (3–5 days per week)",
            "Heavy exercise (6–7 days per week)",
            "Very heavy exercise (twice per day, extra heavy workouts)"
        )
        option.adapter =
            ArrayAdapter<String>(
                requireActivity(),
                android.R.layout.simple_expandable_list_item_1,
                myString
            )

        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                activityLevelPosition = mySpinner.getItemIdAtPosition(p2).toString()
                getActivityLevelPosition()


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }

        // comm = activity as Communicator
        dailyCalorieIntakeTextView.text = ""

        calculateButton.setOnClickListener {
            calculateDailyCalories()
            //  comm.passDataCom(Integer.parseInt(dailyCalorieIntakeTextView.text.toString()))


            if (dailyCalorieIntakeTextView.text != "") {
                ageEditText.text = null
                heightEditText.text = null
                weightEditText.text = null
                womenToggleButton.isChecked = false
                manToggleButton.isChecked = false
            }
        }

        manToggleButton.setOnClickListener {
            womenToggleButton.isChecked = false
            gender = "man"
            dailyCalorieIntakeTextView.text = null
        }

        womenToggleButton.setOnClickListener {
            manToggleButton.isChecked = false
            gender = "women"
            dailyCalorieIntakeTextView.text = null
        }

    }

    private fun getActivityLevelPosition() {
        when (activityLevelPosition) {
            "0" -> activityLevel = 1.toString()
            "1" -> activityLevel = 1.2f.toString()
            "2" -> activityLevel = 1.375f.toString()
            "3" -> activityLevel = 1.55f.toString()
            "4" -> activityLevel = 1.725f.toString()
            "5" -> activityLevel = 1.9f.toString()

            else -> Toast.makeText(
                MainActivity(),
                "Chose your activity level",
                Toast.LENGTH_LONG
            ).show()

        }
    }

    private fun calculateDailyCalories() = when (gender) {
        "man" -> dailyCalorieIntakeTextView.text =
            (((66.47430f + (13.7516f * Integer.parseInt(weightEditText.text.toString())) +
                    (5.0033f * Integer.parseInt(heightEditText.text.toString())) - (6.7550f * Integer.parseInt(
                ageEditText.text.toString()
            ))) * (activityLevel.toFloat())).toString())

        "women" -> dailyCalorieIntakeTextView.text =
            (((655.0955f + (9.5634f * Integer.parseInt(weightEditText.text.toString())) +
                    (1.8496f * Integer.parseInt(heightEditText.text.toString())) - (4.6756f * Integer.parseInt(
                ageEditText.text.toString()
            ))) * (activityLevel.toFloat())).toString())


        else -> Toast.makeText(MainActivity(), "Chose your gender", Toast.LENGTH_LONG).show()
    }
}


