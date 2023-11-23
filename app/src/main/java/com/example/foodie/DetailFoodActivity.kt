package com.example.foodie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.example.foodie.databinding.ActivityDetailFoodBinding
import com.example.foodie.model.dataRestaurant
import com.google.android.material.bottomsheet.BottomSheetBehavior


class DetailFoodActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<dataRestaurant>("DATA")


        // Dapatkan referensi ke elemen "sheet"
        val sheet = findViewById<FrameLayout>(R.id.sheet)


        BottomSheetBehavior.from(sheet).apply {
            peekHeight=200
            this.state=BottomSheetBehavior.STATE_COLLAPSED
        }

    }
}