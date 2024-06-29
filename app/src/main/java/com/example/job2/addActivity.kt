package com.example.job2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class addActivity : AppCompatActivity() {
    private lateinit var profileViewModel: UserProfileViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        profileViewModel = ViewModelProvider(this).get(UserProfileViewModel::class.java)

        val namET = findViewById<EditText>(R.id.nameEt)
        val emaiET = findViewById<EditText>(R.id.emailEt)
        val dobET = findViewById<EditText>(R.id.doB)
        val disET = findViewById<EditText>(R.id.disEt)
        val mobET = findViewById<EditText>(R.id.mobNo)

        findViewById<Button>(R.id.adDbtn).setOnClickListener {
            val name = namET.text.toString()
            val email = emaiET.text.toString()
            val dob = dobET.text.toString()
            val dis = disET.text.toString()
            val mob = mobET.text.toString()

            val userProfile = UserProfile(name = name, email = email, dob = dob, district = dis, mobile = mob)
            profileViewModel.insetUserProfile(userProfile)
            finish()
        }
    }
}