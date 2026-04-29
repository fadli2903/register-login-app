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
<img src="https://github.com/user-attachments/assets/cc52ee5b-0fa0-407c-a7ea-330a09304c0f" width="700" alt="Header Banner">

<img src="https://github.com/user-attachments/assets/856dceeb-2ed8-41ec-beb3-8589040cede4" width="230" title="Main Screen">

  <img src="https://github.com/user-attachments/assets/444eb471-d1fb-4ee2-abc0-4721495f8b68" width="230" title="Form Screen">
  
  <img src="https://github.com/user-attachments/assets/3919d99c-ba66-418f-8e64-db77df608896" width="230" title="Dashboard Screen">
  
  <img src="https://github.com/user-attachments/assets/181ac28c-5771-4762-970b-30edf9380746" width="500" alt="Detail View">



