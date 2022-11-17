package com.example.project01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.project01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var btnMovieList: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnMovieList = findViewById(R.id.btnExplore)


        btnMovieList.setOnClickListener {
            val intent= Intent(this,SecondActivity::class.java)
            startActivity(intent)

        }
    }

    fun onClick(view: View) {}
}