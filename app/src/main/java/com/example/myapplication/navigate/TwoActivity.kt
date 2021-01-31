package com.example.myapplication.navigate

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R

class TwoActivity : BaseNavigateActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.two)

        var model = intent.getParcelableExtra<TwoModel>(EXTRA_TWO_MODEL)
        Log.d(logTag, "Text: ${model?.text}")

        if (model != null) {
            println(model.text)
        }

        model?.let {
            it.text
        }

        model?.apply {

        }

        intent?.extras?.apply {
             model = intent.getParcelableExtra<TwoModel>(EXTRA_TWO_MODEL)
        }
    }

    companion object {
        private const val EXTRA_TWO_MODEL = "two_model"

        fun startIntent(context: Context, model: TwoModel) {
            Intent(context, TwoActivity::class.java)
                .putExtra(EXTRA_TWO_MODEL, model)
                .run { context.startActivity(this) }
        }
    }
}