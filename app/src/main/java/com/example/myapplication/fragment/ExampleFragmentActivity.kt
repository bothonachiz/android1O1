package com.example.myapplication.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.myapplication.R
import com.example.myapplication.navigate.BaseNavigateActivity

class ExampleFragmentActivity : BaseNavigateActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_fragment)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<FirstFragment>(R.id.fragment_container_view)
            }
        }
    }
}