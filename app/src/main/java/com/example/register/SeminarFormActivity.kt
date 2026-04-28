package com.example.register

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.register.databinding.ActivitySeminarFormBinding

class SeminarFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySeminarFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeminarFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSpinner()
        setupRealTimeValidation()

        binding.btnSubmit.setOnClickListener {
            if (validateAll()) {
                if (binding.cbAgree.isChecked) {
                    showConfirmDialog()
                } else {
                    Toast.makeText(this, "Anda harus menyetujui pernyataan di bawah", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setupSpinner() {
        val listSeminar = arrayOf(
            "Seminar Teknologi AI 2024",
            "Workshop Cyber Security",
            "Seminar UI/UX Modern Design",
            "Digital Marketing Masterclass",
            "Penerapan Cloud Computing"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listSeminar)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSeminar.adapter = adapter
    }

    private fun setupRealTimeValidation() {
        binding.etNama.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) { validateNama() }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        binding.etEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) { validateEmail() }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        binding.etHP.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) { validateHP() }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    private fun validateNama(): Boolean {
        val nama = binding.etNama.text.toString().trim()
        return if (nama.isEmpty()) {
            binding.tilNama.error = "Nama tidak boleh kosong"
            false
        } else {
            binding.tilNama.error = null
            true
        }
    }

    private fun validateEmail(): Boolean {
        val email = binding.etEmail.text.toString().trim()
        return if (email.isEmpty()) {
            binding.tilEmail.error = "Email tidak boleh kosong"
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail.error = "Format email tidak valid"
            false
        } else {
            binding.tilEmail.error = null
            true
        }
    }

    private fun validateHP(): Boolean {
        val hp = binding.etHP.text.toString().trim()
        return if (hp.isEmpty()) {
            binding.tilHP.error = "Nomor HP tidak boleh kosong"
            false
        } else if (!hp.startsWith("08")) {
            binding.tilHP.error = "Harus diawali dengan 08"
            false
        } else if (hp.length < 10 || hp.length > 13) {
            binding.tilHP.error = "Panjang harus 10-13 digit"
            false
        } else if (!hp.all { it.isDigit() }) {
            binding.tilHP.error = "Hanya boleh angka"
            false
        } else {
            binding.tilHP.error = null
            true
        }
    }

    private fun validateAll(): Boolean {
        val resNama = validateNama()
        val resEmail = validateEmail()
        val resHP = validateHP()
        val resGender = binding.rgGender.checkedRadioButtonId != -1
        
        if (!resGender) Toast.makeText(this, "Pilih jenis kelamin", Toast.LENGTH_SHORT).show()
        
        return resNama && resEmail && resHP && resGender
    }

    private fun showConfirmDialog() {
        AlertDialog.Builder(this)
            .setTitle("Konfirmasi Data")
            .setMessage("Apakah data yang Anda isi sudah benar?")
            .setPositiveButton("Ya") { _, _ -> kirimData() }
            .setNegativeButton("Tidak", null)
            .show()
    }

    private fun kirimData() {
        val gender = if (binding.rbLaki.isChecked) "Laki-laki" else "Perempuan"
        val intent = Intent(this, SeminarResultActivity::class.java).apply {
            putExtra("NAMA", binding.etNama.text.toString())
            putExtra("EMAIL", binding.etEmail.text.toString())
            putExtra("HP", binding.etHP.text.toString())
            putExtra("GENDER", gender)
            putExtra("SEMINAR", binding.spinnerSeminar.selectedItem.toString())
        }
        startActivity(intent)
    }
}
