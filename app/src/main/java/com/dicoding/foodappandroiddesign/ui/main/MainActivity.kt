package com.dicoding.foodappandroiddesign.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.foodappandroiddesign.data.model.ToursData
import com.dicoding.foodappandroiddesign.databinding.ActivityMainBinding
import com.dicoding.foodappandroiddesign.ui.adapter.MainListAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvTour.layoutManager = LinearLayoutManager(this)
        binding.rvTour.setHasFixedSize(true)
        binding.rvTour.adapter = MainListAdapter(ToursData.collection)

    }
}