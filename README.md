# Register seminar app

Aplikasi Android untuk pendaftaran seminar yang dibangun menggunakan teknologi modern Android.

## Fitur Utama

- **Pendaftaran Seminar**: Form input untuk mendaftarkan peserta seminar.
- **Dashboard**: Tampilan utama yang memberikan ringkasan atau navigasi aplikasi.
- **Integrasi Gambar**: Menggunakan library Glide untuk manajemen pemuatan gambar.
- **Antarmuka Modern**: Kombinasi Jetpack Compose untuk komponen UI baru dan ViewBinding untuk integrasi layout XML.

## Tech Stack

- **Bahasa**: Kotlin
- **UI Framework**: 
  - Jetpack Compose (Material 3)
  - XML Layouts (ViewBinding)
- **SDK**:
  - Min SDK: 26 (Android 8.0 Oreo)
  - Target SDK: 36 (Android 15+)
- **Library**:
  - `androidx.core-ktx`: Ekstensi Kotlin untuk API framework Android.
  - `androidx.navigation-compose`: Navigasi antar layar di Compose.
  - `com.github.bumptech.glide`: Loading dan caching gambar.
  - `com.google.android.material`: Komponen desain material.

## Persyaratan Sistem

- Android Studio Ladybug atau yang lebih baru.
- JDK 11.
- Koneksi internet untuk sinkronisasi library Gradle.

## Cara Menjalankan

1. Clone repositori ini atau download source code.
2. Buka folder proyek di Android Studio.
3. Tunggu hingga proses **Gradle Sync** selesai.
4. Jalankan aplikasi di Emulator atau Perangkat Android fisik.

## Konfigurasi Penting

Proyek ini telah dikonfigurasi menggunakan **AndroidX**. Pastikan file `gradle.properties` memiliki pengaturan berikut:
```properties
android.useAndroidX=true
android.enableJetifier=true
```
