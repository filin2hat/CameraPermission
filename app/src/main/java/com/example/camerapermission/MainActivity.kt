package com.example.camerapermission

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val launcher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            Toast.makeText(
                applicationContext, if (isGranted) "Permission is $isGranted" else
                    "Permission is $isGranted", Toast.LENGTH_SHORT
            ).show()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkPermissions()
    }

    private fun checkPermissions() {
        if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)
//            ContextCompat.checkSelfPermission(
//                applicationContext,
//                Manifest.permission.CAMERA
//            ) == PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(
                applicationContext, "Permission is granted", Toast.LENGTH_SHORT
            ).show()
        } else {
            launcher.launch(Manifest.permission.CAMERA)
        }

    }
}