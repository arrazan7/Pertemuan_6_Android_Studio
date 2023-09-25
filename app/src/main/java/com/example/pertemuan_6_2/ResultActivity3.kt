package com.example.pertemuan_6_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pertemuan_6_2.databinding.ActivityResult3Binding

class ResultActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityResult3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResult3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val savedTujuan = intent.getStringExtra(BusActivity.EXTRA_TUJUAN)
        val savedTanggal = intent.getStringExtra(BusActivity.EXTRA_DATE)
        val savedWaktu = intent.getStringExtra(BusActivity.EXTRA_TIME)

        with(binding) {
            tujuan.text = savedTujuan
            tanggal.text = savedTanggal
            waktu.text= savedWaktu

            btnToast.setOnClickListener {
                Toast.makeText(this@ResultActivity3, "Tiket Bus $savedTujuan pada tanggal $savedTanggal jam $savedWaktu BERHASIL DIPESAN", Toast.LENGTH_SHORT).show()
            }
        }
    }
}