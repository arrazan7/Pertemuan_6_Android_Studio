package com.example.pertemuan_6_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pertemuan_6_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivityLifecycle"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnPesawat.setOnClickListener {
                val intentToPlaneActivity =
                    Intent(this@MainActivity, PlaneActivity::class.java)
                startActivity(intentToPlaneActivity)
            }

            btnKereta.setOnClickListener {
                val intentToTrainActivity =
                    Intent(this@MainActivity, TrainActivity::class.java)
                startActivity(intentToTrainActivity)
            }

            btnBus.setOnClickListener {
                val intentToBusActivity =
                    Intent(this@MainActivity, BusActivity::class.java)
                startActivity(intentToBusActivity)
            }
        }
        Log.d(TAG, "onCreate: dipanggil")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: dipanggil")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: dipanggil")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: dipanggil")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: dipanggil")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: dipanggil")

    }
}