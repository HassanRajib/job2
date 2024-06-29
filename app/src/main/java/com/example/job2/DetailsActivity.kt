package com.example.job2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailsActivity : AppCompatActivity() {
    private lateinit var userProfile: UserProfile

    private lateinit var nameTv: TextView
    private lateinit var emailTv: TextView
    private lateinit var dobTv: TextView
    private lateinit var disTv: TextView
    private lateinit var mobTv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        userProfile = intent.getSerializableExtra("user_Profi") as UserProfile
        nameTv = findViewById(R.id.naMv)
        emailTv = findViewById(R.id.maiLv)
        dobTv = findViewById(R.id.doBv)
        disTv = findViewById(R.id.diSv)
        mobTv = findViewById(R.id.moBv)

        populateFilds()
    }

    private fun populateFilds() {

        nameTv.text = userProfile.name
        emailTv.text = userProfile.email
        dobTv.text = userProfile.dob
        disTv.text = userProfile.district
        mobTv.text = userProfile.mobile
    }
}