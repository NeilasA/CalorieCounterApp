package com.example.CalorieCalculatorApp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.CalorieCalculatorApp.CalorieCalculator
import com.example.CalorieCalculatorApp.R
import kotlinx.android.synthetic.main.fragment_dailycaloriecount.*

class DailyCalorieCountFragment : Fragment() {


    companion object {
        fun newInstance(): DailyCalorieCountFragment {
            val f = DailyCalorieCountFragment()
            val bdl = Bundle(1)
            f.arguments = bdl
            return f
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_dailycaloriecount, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        buttonToCalorieCalculator.setOnClickListener {
            val intent = Intent(activity, CalorieCalculator::class.java)
            startActivity(intent)
        }

        val maxProgress = this.arguments!!.getInt("input_txt")

        progressBar.max = maxProgress
        progressBar.progress = 0
        calorieIntakeEditText!!.text = calorieIntakeEditText.text

        calorieIntakeEditText.setOnKeyListener(View.OnKeyListener { _, keyCode, keyEvent ->
            if ((keyEvent?.action == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                progressBar.progress =
                    (progressBar.progress + Integer.parseInt(calorieIntakeEditText.text.toString())) % maxProgress
                caloriesTextView.text =
                    (progressBar.progress.toString() + "/" + progressBar.max.toString())
                calorieIntakeEditText.text = null
                return@OnKeyListener true
            }
            false
        })

        button.setOnClickListener {
            progressBar.progress = 0
            caloriesTextView.text = ("0/" + progressBar.max)
        }

    }


}