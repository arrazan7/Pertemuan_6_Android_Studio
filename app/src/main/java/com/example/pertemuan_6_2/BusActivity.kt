package com.example.pertemuan_6_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.pertemuan_6_2.databinding.ActivityBusBinding
import com.example.pertemuan_6_2.databinding.ActivityTrainBinding

class BusActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBusBinding
    private lateinit var destinasi: Array<String>

    companion object {
        const val EXTRA_TUJUAN = "extra_tujuan"
        const val EXTRA_DATE = "extra_date"
        const val EXTRA_TIME = "extra_time" // variable dan value HARUS SAMA
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        destinasi = resources.getStringArray(R.array.tujuan_bus)

        with(binding) {
            val adapterDestinasi = ArrayAdapter(
                this@BusActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, destinasi
            )

            adapterDestinasi.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
            spinnerBus.adapter = adapterDestinasi

            var selectedDate = ""
            dateBus.init(
                dateBus.year,
                dateBus.month,
                dateBus.dayOfMonth
            ) { _, year, monthOfYear, dayOfMonth ->
                selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
            }

            var selectedTime = ""
            timeBus.setOnTimeChangedListener { view, hourOfDay, minute ->
                selectedTime = String.format("%02d:%02d", hourOfDay, minute)
            }

            btnBus.setOnClickListener {
                val tujuanBus = spinnerBus.selectedItem.toString()
                val tanggalBus = selectedDate
                val waktuBus = selectedTime

                val intentToResultActivity =
                    Intent(this@BusActivity, ResultActivity3::class.java)
                intentToResultActivity.putExtra(PlaneActivity.EXTRA_TUJUAN, tujuanBus)
                intentToResultActivity.putExtra(PlaneActivity.EXTRA_DATE, tanggalBus)
                intentToResultActivity.putExtra(PlaneActivity.EXTRA_TIME, waktuBus)
                startActivity(intentToResultActivity)
            }
        }
    }
}