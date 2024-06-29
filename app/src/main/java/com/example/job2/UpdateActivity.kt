package com.example.job2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class UpdateActivity : AppCompatActivity() {
    private lateinit var profileViewModel: UserProfileViewModel
    private lateinit var userProfile: UserProfile

    private lateinit var namET: EditText
    private lateinit var emaiET: EditText
    private lateinit var dobET: EditText
    private lateinit var disET: EditText
    private lateinit var mobET: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        profileViewModel = ViewModelProvider(this).get(UserProfileViewModel::class.java)
        userProfile = intent.getSerializableExtra("user_Profi") as UserProfile

        namET = findViewById(R.id.nameEt)
        emaiET = findViewById(R.id.emailEt)
        dobET = findViewById(R.id.doB)
        disET = findViewById(R.id.disEt)
        mobET = findViewById(R.id.mobNo)

        populateFilds()

        findViewById<Button>(R.id.upDBtn).setOnClickListener {
            updateUserProfile()
        }
    }

    private fun updateUserProfile() {
        val name = namET.text.toString()
        val email = emaiET.text.toString()
        val dob = dobET.text.toString()
        val dis = disET.text.toString()
        val mob = mobET.text.toString()

        val updateUserProfile = UserProfile(id = userProfile.id, name = name, email = email, dob = dob, district = dis, mobile = mob)
        profileViewModel.insetUserProfile(updateUserProfile)
        finish()
    }


    private fun populateFilds() {

            namET.setText(userProfile.name)
            emaiET.setText(userProfile.email)
            dobET.setText(userProfile.dob)
            disET.setText(userProfile.district)
            mobET.setText(userProfile.mobile)
        }
    }