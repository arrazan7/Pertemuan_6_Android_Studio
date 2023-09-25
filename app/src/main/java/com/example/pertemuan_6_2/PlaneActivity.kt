package com.example.pertemuan_6_2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.pertemuan_6_2.databinding.ActivityPlaneBinding

class PlaneActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlaneBinding
    private lateinit var destinasi: Array<String>

    companion object {
        const val EXTRA_TUJUAN = "extra_tujuan"
        const val EXTRA_DATE = "extra_date"
        const val EXTRA_TIME = "extra_time" // variable dan value HARUS SAMA
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        destinasi = resources.getStringArray(R.array.tujuan_pesawat)

        with(binding) {
            val adapterDestinasi = ArrayAdapter(
                this@PlaneActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, destinasi
            )
            adapterDestinasi.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
            spinnerPesawat.adapter = adapterDestinasi

            var selectedDate = ""
            datePesawat.init(
                datePesawat.year,
                datePesawat.month,
                datePesawat.dayOfMonth
            ) { _, year, monthOfYear, dayOfMonth ->
                selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
            }

            var selectedTime = ""
            timePesawat.setOnTimeChangedListener { view, hourOfDay, minute ->
                selectedTime = String.format("%02d:%02d", hourOfDay, minute)
            }

            btnPesawat.setOnClickListener {
                val tujuanPesawat = spinnerPesawat.selectedItem.toString()
                val tanggalPesawat = selectedDate
                val waktuPesawat = selectedTime

                val intentToResultActivity =
                    Intent(this@PlaneActivity, ResultActivity::class.java)
                intentToResultActivity.putExtra(EXTRA_TUJUAN, tujuanPesawat)
                intentToResultActivity.putExtra(EXTRA_DATE, tanggalPesawat)
                intentToResultActivity.putExtra(EXTRA_TIME, waktuPesawat)
                startActivity(intentToResultActivity)
            }

        }
    }
}