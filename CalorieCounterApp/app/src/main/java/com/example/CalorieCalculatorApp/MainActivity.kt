package com.example.CalorieCalculatorApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.CalorieCalculatorApp.fragments.DailyCalorieCountFragment
import com.example.CalorieCalculatorApp.fragments.MonthlyCalorieCountFragment
import com.example.CalorieCalculatorApp.ui.main.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    //--use Communicator to pass data from fragments


    private lateinit var viewpager: ViewPager
    private lateinit var tabs: TabLayout

  //  lateinit var calorieCalculatorFragment: CalorieCalculatorFragment
    lateinit var dailyCalorieCountFragment: DailyCalorieCountFragment
    lateinit var monthlyCalorieCountFragment: MonthlyCalorieCountFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dailyCalorieCountFragment = DailyCalorieCountFragment.newInstance()
        monthlyCalorieCountFragment = MonthlyCalorieCountFragment.newInstance()
     //   calorieCalculatorFragment = CalorieCalculatorFragment.newInstance()

        initViews()
        setupViewPager()

     //   val maxDailyCalories = intent.getStringExtra("maxDailyCalories")
    }


    private fun initViews() {
        tabs = this.findViewById(R.id.tabs)
        viewpager = findViewById(R.id.view_pager)
    }

    private fun setupViewPager() {

        val adapter = SectionsPagerAdapter(supportFragmentManager)


        adapter.addFragment(dailyCalorieCountFragment, "Daily Calorie Intake")
        adapter.addFragment(monthlyCalorieCountFragment, "Monthly Calorie Intake")
       // adapter.addFragment(calorieCalculatorFragment,"Calorie Calculator")

        viewpager.adapter = adapter

        tabs.setupWithViewPager(viewpager)

    }
//    override fun passDataCom(edittext_input: Int) {
//        val bundle = Bundle()
//        bundle.putInt("input_txt",Integer.parseInt(dailyCalorieIntakeTextView.text.toString()))
//        val frag2 = DailyCalorieCountFragment()
//        frag2.arguments = bundle
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.content_id, frag2)
//            .addToBackStack(frag2.toString())
//            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//            .commit()
//    }
}
