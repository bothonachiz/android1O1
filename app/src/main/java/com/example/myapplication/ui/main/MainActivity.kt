package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val recyclerViewItemAdapter: RecyclerViewItemAdapter by lazy {
        RecyclerViewItemAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpView()
    }

    private fun setUpView() {
        binding.rvItems.adapter = recyclerViewItemAdapter
        binding.rvItems.layoutManager = LinearLayoutManager(this)
        recyclerViewItemAdapter.update(mockItems())
    }

    private fun mockItems(): List<RecyclerViewItemModel> {
        return listOf(
            RecyclerViewItemModel(
                image = R.drawable.logo_odds,
                name = "Name1"
            ),
            RecyclerViewItemModel(
                image = R.drawable.logo_odds,
                name = "Name1"
            ),
            RecyclerViewItemModel(
                image = R.drawable.logo_odds,
                name = "Name1"
            ), RecyclerViewItemModel(
                image = R.drawable.logo_odds,
                name = "Name1"
            ),
            RecyclerViewItemModel(
                image = R.drawable.logo_odds,
                name = "Name1"
            )
        )
    }
}