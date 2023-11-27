package com.example.foodie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodie.Adapter.ListRestAdapter
import com.example.foodie.databinding.ActivityDetailRestaurantBinding
import com.example.foodie.model.dataRestaurant

class DetailRestaurantActivity : AppCompatActivity() {

    private var list = ArrayList<dataRestaurant>()
    private lateinit var binding: ActivityDetailRestaurantBinding
    private lateinit var rvRest: RecyclerView
    private lateinit var btnMove: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnMove = findViewById(R.id.btn_move_back)

        btnMove.setOnClickListener{
            val intent = Intent(this@DetailRestaurantActivity,
                MainActivity::class.java)

            startActivity(intent)
        }

        rvRest = binding.rvMain
        rvRest.setHasFixedSize(true)

        list.addAll(getListRest())
        showRecyclerView()
    }

    private fun showRecyclerView(){
        rvRest.layoutManager = LinearLayoutManager(this)

        val listRestAdapter = ListRestAdapter(list)
        rvRest.adapter = listRestAdapter
    }

    private fun getListRest(): ArrayList<dataRestaurant> {
        val nameArray = resources.getStringArray(R.array.data_name_more)
        val minutesArray = resources.getStringArray(R.array.data_minutes_more)
        val milesArray = resources.getStringArray(R.array.data_miles_more)
        val starArray = resources.getStringArray(R.array.data_star_more)
        val imagesArray = resources.obtainTypedArray(R.array.data_photos_more)
        val rest = ArrayList<dataRestaurant>()

        for (i in nameArray.indices) {
            val food = dataRestaurant(
                nameArray[i],
                minutesArray[i],
                milesArray[i],
                starArray[i],
                imagesArray.getResourceId(i, -1)
            )
            rest.add(food)
        }

        imagesArray.recycle()

        return rest
    }

}