package com.example.register

import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.register.databinding.ActivitySeminarResultBinding
import java.io.OutputStream

class SeminarResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySeminarResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeminarResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nama = intent.getStringExtra("NAMA") ?: "-"
        val email = intent.getStringExtra("EMAIL") ?: "-"
        val hp = intent.getStringExtra("HP") ?: "-"
        val gender = intent.getStringExtra("GENDER") ?: "-"
        val seminar = intent.getStringExtra("SEMINAR") ?: "-"

        binding.resNama.text = nama
        binding.resEmail.text = email
        binding.resHP.text = hp
        binding.resGender.text = gender
        binding.resSeminar.text = seminar

        binding.btnSaveImage.setOnClickListener {
            binding.cardResult.post {
                val bitmap = getBitmapFromView(binding.cardResult)
                saveBitmapToGallery(bitmap)
            }
        }

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }

    private fun getBitmapFromView(view: View): Bitmap {
        val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        view.draw(canvas)
        return bitmap
    }

    private fun saveBitmapToGallery(bitmap: Bitmap) {
        val filename = "Seminar_Registration_${System.currentTimeMillis()}.jpg"
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
            put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                put(MediaStore.MediaColumns.RELATIVE_PATH, "DCIM/SeminarApp")
            }
        }

        val imageUri: Uri? = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
        
        try {
            imageUri?.let { uri ->
                contentResolver.openOutputStream(uri)?.use { fos ->
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
                    Toast.makeText(this, "Berhasil disimpan ke Galeri", Toast.LENGTH_SHORT).show()
                }
            } ?: throw Exception("Gagal membuat URI gambar")
        } catch (e: Exception) {
            Toast.makeText(this, "Gagal menyimpan: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}
