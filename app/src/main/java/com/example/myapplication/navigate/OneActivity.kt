package com.example.myapplication.navigate

import android.os.Bundle
import com.example.myapplication.databinding.ActivityOneBinding

class OneActivity : BaseNavigateActivity() {

    private val binding: ActivityOneBinding by lazy {
        ActivityOneBinding.inflate((layoutInflater))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpView()
    }

    private fun setUpView() {
        binding.btnNext.setOnClickListener {
            val extraString = binding.edtText.text.toString()
            TwoActivity.startIntent(this, TwoModel(text = extraString))
        }
    }

}