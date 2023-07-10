package com.example.growgh

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val feedBtn = findViewById<Button>(R.id.feeds)
        val uploadBtn = findViewById<Button>(R.id.upload)


        feedBtn.setOnClickListener {
            val intent = Intent(this , FeedPage::class.java)
            startActivity(intent)
        }
        uploadBtn.setOnClickListener {
            val intent = Intent(this , UploadPage::class.java)
            startActivity(intent)
        }
    }
}