package com.example.myapplication

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivityOneBinding
import com.example.myapplication.databinding.ActivityPermissionBinding
import com.example.myapplication.navigate.TwoActivity
import com.example.myapplication.navigate.TwoModel
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener

class PermissionActivity : AppCompatActivity() {

    private val logTag: String
        get() = this::class.java.simpleName

    private val binding: ActivityPermissionBinding by lazy {
        ActivityPermissionBinding.inflate((layoutInflater))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpView()
    }

    private fun requirePermission() {
        Dexter.withContext(this)
            .withPermission(Manifest.permission.CAMERA)
            .withListener(object : PermissionListener {
                override fun onPermissionGranted(grantedResponse: PermissionGrantedResponse?) {
                    Log.d(logTag, "onPermissionGranted")
                }

                override fun onPermissionDenied(deniedResponse: PermissionDeniedResponse?) {
                    Log.d(logTag, "onPermissionDenied")
                }

                override fun onPermissionRationaleShouldBeShown(
                    request: PermissionRequest?,
                    token: PermissionToken?
                ) {
                    Log.d(logTag, "onPermissionRationaleShouldBeShown")
                    token?.continuePermissionRequest()
                }
            }).check()
    }

    private fun setUpView() {
        binding.btnRequestPermission.setOnClickListener {
            requirePermission();
        }
    }
}