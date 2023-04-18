package com.cookandroid.healnion

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.icu.util.Calendar
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.CalendarView
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var imageView: ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val intent = Intent(this@MainActivity, RecordActivity::class.java)
            intent.putExtra("selected_year", year)
            intent.putExtra("selected_month", month)
            intent.putExtra("selected_day", dayOfMonth)
            startActivity(intent)
        }

        val intent = Intent(this, LoadingActivity::class.java)
        startActivity(intent) // 로딩화면

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_record -> {

                }
                R.id.menu_search -> {

                }
                R.id.menu_routine -> {

                }
            }
            true
        }

        imageView = findViewById(R.id.myImageView)
        val button = findViewById<Button>(R.id.myButton)
        button.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            val imageUri: Uri = data.data!!
            imageView.setImageURI(imageUri)
        }


    }





}





