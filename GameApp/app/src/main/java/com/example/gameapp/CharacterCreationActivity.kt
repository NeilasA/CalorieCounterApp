package com.example.gameapp

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast

class CharacterCreationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_character_creation)


        val warriorSelected = findViewById<ImageView>(R.id.warriorImageView)
        val mageSelected = findViewById<ImageView>(R.id.mageImageView)
        val archerSelected = findViewById<ImageView>(R.id.archerImageView)
        val rogueSelected = findViewById<ImageView>(R.id.rogueImageView)

        warriorSelected.setOnClickListener {
            val intent = (Intent(this,WarriorPath::class.java))
            startActivity(intent)
        }
        mageSelected.setOnClickListener {
            Toast.makeText(this,"Sorry Only Warrior Path Was Put In This App", Toast.LENGTH_LONG).show()
        }
        archerSelected.setOnClickListener {
            Toast.makeText(this,"Sorry Only Warrior Path Was Put In This App", Toast.LENGTH_LONG).show()
        }
        rogueSelected.setOnClickListener {
            Toast.makeText(this,"Sorry Only Warrior Path Was Put In This App", Toast.LENGTH_LONG).show()
        }
    }
}
