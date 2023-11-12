package com.dicoding.foodappandroiddesign.ui.detail

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.foodappandroiddesign.data.model.Tours
import com.dicoding.foodappandroiddesign.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tour = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_Tour,Tours::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_Tour)

        }
        if (tour != null) {
            setData(tour)
        }
    }

    private fun setData(tours: Tours) {
        binding.apply {
            imgDetail.setImageResource(tours.picture)
            tvName.text = tours.name
            tvDescription.text = tours.description
            tvRating.text = tours.rating.toString()
            tvPrice.text = tours.ticket.toString()

        }
    }

    companion object {
        const val EXTRA_Tour = "extra_tour"
    }
}