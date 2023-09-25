package com.example.pertemuan_6_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.pertemuan_6_2.databinding.ActivityPlaneBinding
import com.example.pertemuan_6_2.databinding.ActivityTrainBinding

class TrainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTrainBinding
    private lateinit var destinasi: Array<String>

    companion object {
        const val EXTRA_TUJUAN = "extra_tujuan"
        const val EXTRA_DATE = "extra_date"
        const val EXTRA_TIME = "extra_time" // variable dan value HARUS SAMA
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        destinasi = resources.getStringArray(R.array.tujuan_kereta)

        with(binding) {
            val adapterDestinasi = ArrayAdapter(
                this@TrainActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, destinasi
            )

            adapterDestinasi.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
            spinnerKereta.adapter = adapterDestinasi

            var selectedDate = ""
            dateKereta.init(
                dateKereta.year,
                dateKereta.month,
                dateKereta.dayOfMonth
            ) { _, year, monthOfYear, dayOfMonth ->
                selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
            }

            var selectedTime = ""
            timeKereta.setOnTimeChangedListener { view, hourOfDay, minute ->
                selectedTime = String.format("%02d:%02d", hourOfDay, minute)
            }

            btnKereta.setOnClickListener {
                val tujuanKereta = spinnerKereta.selectedItem.toString()
                val tanggalKereta = selectedDate
                val waktuKereta = selectedTime

                val intentToResultActivity =
                    Intent(this@TrainActivity, ResultActivity2::class.java)
                intentToResultActivity.putExtra(PlaneActivity.EXTRA_TUJUAN, tujuanKereta)
                intentToResultActivity.putExtra(PlaneActivity.EXTRA_DATE, tanggalKereta)
                intentToResultActivity.putExtra(PlaneActivity.EXTRA_TIME, waktuKereta)
                startActivity(intentToResultActivity)
            }
        }
    }
}