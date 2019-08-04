package com.example.gameapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        val exitGame = findViewById<Button>(R.id.quitButton)
        val newGame = findViewById<Button>(R.id.newGameButton)
        val continueGame = findViewById<Button>(R.id.continueButton)

        exitGame.setOnClickListener {
            finishAffinity()
            //System.exit(-1)
        }


        newGame.setOnClickListener{
             val intent = (Intent(this,CharacterCreationActivity::class.java))
            startActivity(intent)
         }

        continueGame.setOnClickListener{
            Toast.makeText(this,"This Continue Button Is Just For A Show", Toast.LENGTH_LONG).show()
        }


    }


}
