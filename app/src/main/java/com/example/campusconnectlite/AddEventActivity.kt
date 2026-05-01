package com.example.campusconnectlite

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddEventActivity : AppCompatActivity() {

    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_event)

        databaseHelper = DatabaseHelper(this)

        val etName = findViewById<EditText>(R.id.etEventName)
        val etDesc = findViewById<EditText>(R.id.etEventDesc)
        val etLocation = findViewById<EditText>(R.id.etEventLocation)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnBack = findViewById<TextView>(R.id.btnBack)

        // Fitur Tombol Back (Kembali)
        btnBack.setOnClickListener {
            finish() // Langsung tutup halaman ini
        }

        btnSave.setOnClickListener {
            val name = etName.text.toString().trim()
            val desc = etDesc.text.toString().trim()
            val location = etLocation.text.toString().trim()

            if (name.isEmpty() || desc.isEmpty() || location.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val event = EventModel(name = name, description = desc, location = location)
            val status = databaseHelper.insertEvent(event)

            if (status > -1) {
                Toast.makeText(this, "Event Berhasil Disimpan", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Gagal menyimpan data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}