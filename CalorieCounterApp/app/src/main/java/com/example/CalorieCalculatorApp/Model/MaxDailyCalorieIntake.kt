package com.example.CalorieCalculatorApp.Model

import com.google.firebase.database.DataSnapshot

class MaxDailyCalorieIntake(snapshot: DataSnapshot? ) {
    lateinit var id: String
    lateinit var maxDailyCalorieIntake: String

    init {
        if (snapshot != null) {
            createMaxDailyCalorieIntake(snapshot)
        }
    }

    private fun createMaxDailyCalorieIntake(snapshot: DataSnapshot){
        try {
            val data: HashMap<String, Any> = snapshot.value as HashMap<String, Any>
            id = snapshot.key ?: ""
            maxDailyCalorieIntake = data["maxDailyCalorieIntake"] as String
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }


    fun toMap(): HashMap<String, Any> {
        val map: HashMap<String, Any> = HashMap()
        map["maxDailyCalorieIntake"] = maxDailyCalorieIntake
        return map
    }
}

