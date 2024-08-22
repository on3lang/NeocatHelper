package com.onelang.neocatHelper

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val infoFormButton: ImageButton = findViewById(R.id.infoFormButton)
        infoFormButton.setOnClickListener {
            val intent = Intent(this, InfoFormActivity::class.java)
            startActivity(intent)
        }

        val formButton: Button = findViewById(R.id.submitButton)
        formButton.setOnClickListener {
            val message = "Hola"

            val sendIntent = Intent(Intent.ACTION_VIEW)
            sendIntent.data = Uri.parse("http://api.whatsapp.com/send?text=$message")

            try {
                startActivity(sendIntent)
            } catch (e: Exception) {
                Toast.makeText(this, "WhatsApp non è installato", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}