package com.example.pertemuan_6_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pertemuan_6_2.databinding.ActivityResult2Binding

class ResultActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityResult2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResult2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val savedTujuan = intent.getStringExtra(TrainActivity.EXTRA_TUJUAN)
        val savedTanggal = intent.getStringExtra(TrainActivity.EXTRA_DATE)
        val savedWaktu = intent.getStringExtra(TrainActivity.EXTRA_TIME)

        with(binding) {
            tujuan.text = savedTujuan
            tanggal.text = savedTanggal
            waktu.text= savedWaktu

            btnToast.setOnClickListener {
                Toast.makeText(this@ResultActivity2, "Tiket Kereta $savedTujuan pada tanggal $savedTanggal jam $savedWaktu BERHASIL DIPESAN", Toast.LENGTH_SHORT).show()
            }
        }
    }
}