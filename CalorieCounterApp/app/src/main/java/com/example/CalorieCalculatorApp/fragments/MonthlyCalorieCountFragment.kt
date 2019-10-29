package com.example.CalorieCalculatorApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.CalorieCalculatorApp.R

class MonthlyCalorieCountFragment : Fragment() {
    companion object {
        fun newInstance(): MonthlyCalorieCountFragment {
            val f = MonthlyCalorieCountFragment()
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
        return inflater.inflate(R.layout.fragment_mounthlycaloriecount, container, false)
    }


}