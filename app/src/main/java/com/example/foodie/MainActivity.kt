package com.example.foodie


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodie.Adapter.ListFoodAdapter
import com.example.foodie.databinding.ActivityMainBinding
import com.example.foodie.model.dataRestaurant

class MainActivity : AppCompatActivity() {

    private var list = ArrayList<dataRestaurant>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvFood: RecyclerView
    private lateinit var tv_move: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        installSplashScreen()
        setContentView(binding.root)

        tv_move = findViewById(R.id.tv_move)

        tv_move.setOnClickListener{
            val intent = Intent(this@MainActivity, DetailRestaurantActivity::class.java)

            startActivity(intent)
        }

        rvFood = binding.rvMain
        rvFood.setHasFixedSize(true)

        list.addAll(getListFood())
        showRecycleView()

    }

    private fun showRecycleView() {
        rvFood.layoutManager = LinearLayoutManager(this)

        val listFoodAdapter = ListFoodAdapter(list)
        rvFood.adapter = listFoodAdapter
    }

    private fun getListFood(): ArrayList<dataRestaurant> {
        val name = resources.getStringArray(R.array.data_name)
        val minutes = resources.getStringArray(R.array.data_minutes)
        val miles = resources.getStringArray(R.array.data_miles)
        val star = resources.getStringArray(R.array.data_star)
        val image = resources.obtainTypedArray(R.array.data_photos)
        val Foods = ArrayList<dataRestaurant>()

        for (i in name.indices){
            val food = dataRestaurant(
                name[i],
                minutes[i],
                miles[i],
                star[i],
                image.getResourceId(i, -1)
            )
            Foods.addAll(listOf(food))
        }
        return Foods
    }
}