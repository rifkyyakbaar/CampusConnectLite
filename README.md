# CampusConnectLite

Aplikasi Android sederhana untuk pendataan acara (event) kampus. Proyek ini merupakan purwarupa (versi *lite*) dari sistem **CampusConnect** yang berfokus pada implementasi *local database*. Dibuat khusus untuk memenuhi Tugas 4 - Implementasi Database SQLite dan RecyclerView.

## ✨ Fitur Aplikasi
* **Tambah Event (Create):** Form input untuk menambahkan Nama, Deskripsi, dan Lokasi event kampus ke dalam *database* lokal.
* **Daftar Event (Read):** Menampilkan seluruh data event yang telah disimpan dalam bentuk *list* yang dinamis dan rapi.
* **Hapus Event (Delete):** Fitur untuk menghapus event langsung dari daftar.
* **Validasi Input:** Sistem pencegahan agar pengguna tidak menyimpan form dalam keadaan kosong.
* **Empty State:** Tampilan antarmuka khusus ketika belum ada data event yang tersimpan.

## 🛠️ Teknologi yang Digunakan
* **Bahasa Pemrograman:** Kotlin
* **Database:** SQLite (`SQLiteOpenHelper`)
* **Komponen UI Utama:** `RecyclerView`, `CardView`, `ConstraintLayout`, dan `LinearLayout`.
* **Arsitektur:** Native Android App

---
*Developed by Rifky Akbar Utomo Putra*
