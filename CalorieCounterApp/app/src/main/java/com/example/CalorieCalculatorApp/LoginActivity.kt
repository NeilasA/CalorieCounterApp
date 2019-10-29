package com.example.CalorieCalculatorApp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        backToRegistration_textView.setOnClickListener {
            val intent = Intent(this, RegActivity::class.java)
            startActivity(intent)
        }
        signIn_button.setOnClickListener{
            performSignIn()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
    private fun performSignIn() {
        val email = logInEmail_editText.text.toString()
        val password = logInPassword_editText.text.toString()
        //val username = username_editText.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter text", Toast.LENGTH_LONG).show()
            return
        }

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful)

                    return@addOnCompleteListener

            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to login an user: ${it.message}", Toast.LENGTH_LONG).show()
            }
    }
}