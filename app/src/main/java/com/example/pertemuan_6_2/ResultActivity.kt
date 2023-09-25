package com.example.pertemuan_6_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pertemuan_6_2.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val savedTujuan = intent.getStringExtra(PlaneActivity.EXTRA_TUJUAN)
        val savedTanggal = intent.getStringExtra(PlaneActivity.EXTRA_DATE)
        val savedWaktu = intent.getStringExtra(PlaneActivity.EXTRA_TIME)

        with(binding) {
            tujuan.text = savedTujuan
            tanggal.text = savedTanggal
            waktu.text= savedWaktu

            btnToast.setOnClickListener {
                Toast.makeText(this@ResultActivity, "Tiket Pesawat $savedTujuan pada tanggal $savedTanggal jam $savedWaktu BERHASIL DIPESAN", Toast.LENGTH_SHORT).show()
            }
        }
    }
}