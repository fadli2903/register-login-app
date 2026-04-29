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





## UI APP
🔐 Login
<img src="https://github.com/user-attachments/assets/181ac28c-5771-4762-970b-30edf9380746" width="300"/>
📝 Register
<img src="https://github.com/user-attachments/assets/1efb78aa-c2e6-4538-8b8f-1d2127112edf" width="300"/>
🎓 Dashboard
<img src="https://github.com/user-attachments/assets/e2c6da84-1b51-4c1b-8127-fa1f3646d864" width="300"/>
🧾 Form Seminar
<img src="https://github.com/user-attachments/assets/07d032f4-f4b9-41dd-8b7d-48419bf7a607" width="300"/>
📋 Detail Data
<img src="https://github.com/user-attachments/assets/704a35ca-7096-484a-ba05-b2d36a566183" width="300"/>



