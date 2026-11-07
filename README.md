
Coffee and Bites – Aplikasi Mobile

Coffee and Bites adalah aplikasi mobile berbasis Android yang dikembangkan menggunakan Kotlin dan XML. Aplikasi ini memungkinkan pengguna untuk melihat berbagai pilihan menu kopi, minuman non-kopi, dan makanan penutup, menyesuaikan pesanan, mengelola keranjang belanja, serta melakukan pemesanan melalui antarmuka yang sederhana dan mudah digunakan.

Aplikasi ini dirancang berdasarkan wireframe tugas dan panduan desain UI, dengan mengusung tema warna khas kopi yang hangat serta pengalaman penggunaan yang intuitif.

Fitur Aplikasi

1. Splash & Welcome Screen
- Menampilkan identitas dan branding Coffee and Bites.
- Memberikan tampilan awal yang menarik kepada pengguna.

2. Autentikasi
- Halaman Sign Up dan Login.
- Validasi input data pengguna.
- Fitur untuk menampilkan dan menyembunyikan kata sandi.
- Antarmuka autentikasi yang mudah digunakan.

3. Menu Utama & Kategori
- Menampilkan berbagai produk makanan dan minuman.
- Penyaringan menu berdasarkan kategori secara dinamis:
  - Coffee
  - Non-Coffee
  - Dessert
- Menampilkan informasi produk dan pilihan menu.

4. Kustomisasi Produk
- Menggunakan antarmuka Bottom Sheet untuk menyesuaikan produk yang dipilih.
- Pilihan kustomisasi meliputi:
  - Jumlah pesanan (Quantity)
  - Ukuran minuman (Size)
  - Jenis susu (Milk Type)
  - Tingkat kemanisan (Sugar Level)
  - Tambahan espresso (Extra Shot) untuk produk kopi tertentu.
- Pilihan kustomisasi menyesuaikan dengan kategori produk yang dipilih.

5. Keranjang Belanja
- Tombol keranjang belanja yang mengambang (Floating Action Cart Button).
- Penghitung jumlah item dalam keranjang secara dinamis.
- Menambahkan dan mengelola produk yang dipilih.
- Melihat daftar pesanan sebelum melakukan checkout.

6. Proses Pemesanan

Proses pemesanan terdiri dari beberapa tahapan:

- Shipping Address: Pengguna mengisi informasi penerima dan alamat pengiriman.
- Order Validation: Menampilkan detail pesanan dan melakukan validasi terhadap item yang dipilih.
- Order Confirmation: Menampilkan konfirmasi bahwa pesanan berhasil dilakukan dengan indikator tanda centang.

7. Profil Pengguna
- Menampilkan informasi profil pengguna.
- Menyediakan tampilan pengaturan profil.

Teknologi & Tools

- Bahasa Pemrograman: Kotlin
- Desain Antarmuka: Android XML Layouts
- Komponen UI: Material Design Components
- Sistem Desain: Material 3
- IDE: Android Studio
- Minimum SDK: API 21 (Android 5.0 Lollipop)
- Target SDK: API 34 (Android 14)

Struktur Proyek


app/
└── src/
    └── main/
        ├── java/
        │   └── com/example/coffeeandbites/
        │       ├── SplashActivity.kt
        │       ├── SignUpActivity.kt
        │       ├── LoginActivity.kt
        │       ├── RegisterActivity.kt
        │       ├── HomeActivity.kt
        │       ├── ProfileActivity.kt
        │       ├── ShippingAddressActivity.kt
        │       ├── OrderValidationActivity.kt
        │       ├── OrderConfirmationActivity.kt
        │       ├── MenuAdapter.kt
        │       ├── MenuItem.kt
        │       ├── CartItem.kt
        │       └── CartManager.kt
        │
        └── res/
            ├── layout/
            │   ├── activity_splash.xml
            │   ├── activity_sign_up.xml
            │   ├── activity_login.xml
            │   ├── activity_register.xml
            │   ├── activity_home.xml
            │   ├── activity_profile.xml
            │   ├── activity_shipping_address.xml
            │   ├── activity_order_validation.xml
            │   ├── activity_order_confirmation.xml
            │   ├── dialog_customize_menu.xml
            │   └── item_menu.xml
            │
            └── drawable/

Konsep Desain UI

Aplikasi ini menggunakan konsep desain bertema kopi dengan kombinasi warna yang hangat dan nyaman dipandang.

Beberapa elemen desain yang diterapkan:
- Kombinasi warna khas kopi.
- Tata letak yang bersih dan terorganisir.
- Kolom input dan tombol dengan sudut membulat.
- Penggunaan tipografi dan jarak antarelemen yang konsisten.
- Navigasi yang mudah dipahami.
- Tampilan responsif menggunakan Android XML.

Cara Menjalankan Proyek

Ikuti langkah-langkah berikut untuk menjalankan aplikasi:

1. Clone atau unduh repositori proyek ini.
2. Buka proyek menggunakan Android Studio.
3. Tunggu hingga proses Gradle Sync selesai.
4. Hubungkan perangkat Android atau jalankan emulator.
5. Build dan jalankan aplikasi.

Informasi Proyek

- Nama Proyek: Coffee and Bites
- Platform: Android
- Bahasa Pemrograman: Kotlin
- Layout: XML
- Lingkungan Pengembangan: Android Studio
- Target Platform: Android 14


Coffee and Bites – Kopi dan Camilan Favorit Anda, Kini dalam Satu Sentuhan!
