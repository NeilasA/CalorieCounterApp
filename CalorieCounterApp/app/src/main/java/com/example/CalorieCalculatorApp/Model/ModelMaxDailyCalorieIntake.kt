package com.example.CalorieCalculatorApp.Model

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*

object ModelMaxDailyCalorieIntake: Observable() {
    private fun getDatabaseRef(): DatabaseReference? {
        return FirebaseDatabase.getInstance().reference.child("maxDailyCalorieIntakeChild")
    }

    fun saveMaxDailyCalorieIntake(c: MaxDailyCalorieIntake, onComplete: OnCompleteListener<Void>) {
        val reference = getDatabaseRef()?.push()
        reference?.updateChildren(c.toMap())?.addOnCompleteListener{ task ->
            if (task.isComplete) {
                onComplete.onComplete(task)
                setChanged()
                notifyObservers()
            }
        }
    }
}