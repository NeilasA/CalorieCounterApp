package com.example.CalorieCalculatorApp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.content_reg.*

class RegActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)
        //setSupportActionBar(toolbar)

        singUp_button.setOnClickListener {
            performRegister()
            val intent = Intent (this, LoginActivity::class.java)
            startActivity(intent)
      }

        alreadyHaveAnAccount_textView.setOnClickListener{
           val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
    private fun performRegister(){
        val email = logInEmail_editText.text.toString()
        val password = logInPassword_editText.text.toString()
        //val username = username_editText.text.toString()

        if(email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter text", Toast.LENGTH_LONG).show()
            return
        }

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (!it.isSuccessful)
                    // Toast.makeText(this, "User Created", Toast.LENGTH_LONG).show()
                    return@addOnCompleteListener

            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to create an user: ${it.message}", Toast.LENGTH_LONG).show()
            }
    }

}

