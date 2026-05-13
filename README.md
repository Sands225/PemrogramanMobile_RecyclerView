# Bali Tourism App

<div align="center">

![Android](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Material Design](https://img.shields.io/badge/Material_Design-757575?style=for-the-badge&logo=material-design&logoColor=white)
![Min SDK](https://img.shields.io/badge/Min_SDK-24-blue?style=for-the-badge)
![Target SDK](https://img.shields.io/badge/Target_SDK-36-blue?style=for-the-badge)

**Aplikasi Android untuk menampilkan daftar tempat wisata populer di Bali menggunakan RecyclerView.**

</div>

---

## Deskripsi

**Bali Tourism App** adalah aplikasi Android native yang dikembangkan sebagai bagian dari tugas pengganti Ujian Tengah Semester pada mata kuliah Pemrograman Mobile A.. Aplikasi ini menampilkan informasi mengenai destinasi wisata terkenal di Pulau Bali. Aplikasi ini dibangun sebagai bagian dari tugas **Pemrograman Mobile** untuk mendemonstrasikan penggunaan `RecyclerView` dengan custom adapter dan `MaterialCardView` dalam pengembangan aplikasi Android.

Setiap item destinasi wisata menampilkan:
- **Gambar** lokasi wisata
- **Nama** tempat wisata
- **Lokasi** (kabupaten/kota)
- **Deskripsi** singkat mengenai tempat tersebut

## Fitur

- Daftar **9 destinasi wisata** populer di Bali
- Tampilan **Material Card** dengan rounded corners & elevation
- **Rounded images** menggunakan `ShapeableImageView`
- UI yang bersih dan modern dengan tema **Material Components**
- **RecyclerView** dengan `LinearLayoutManager` untuk scrolling yang efisien
- Desain minimalis dengan palet warna yang konsisten

## Destinasi Wisata

| No | Tempat Wisata | Lokasi |
|----|---------------------------|----------------------|
| 1  | Tanah Lot                 | Tabanan, Bali        |
| 2  | Uluwatu Temple            | South Kuta, Badung   |
| 3  | Tegallalang Rice Terrace  | Ubud, Gianyar        |
| 4  | Mount Batur               | Kintamani, Bangli    |
| 5  | Besakih Temple            | Karangasem, Bali     |
| 6  | Nusa Penida               | Klungkung, Bali      |
| 7  | Sanur Beach               | Denpasar, Bali       |
| 8  | Garuda Wisnu Kencana      | Ungasan, Badung      |
| 9  | Sekumpul Waterfall        | Buleleng, Bali       |

## Tech Stack

| Teknologi | Versi | Keterangan |
|-----------|-------|------------|
| **Kotlin** | 2.0.21 | Bahasa pemrograman utama |
| **Android Gradle Plugin** | 8.13.2 | Build system |
| **RecyclerView** | 1.4.0 | Menampilkan daftar item secara efisien |
| **Material Components** | 1.11.0 | UI components (`MaterialCardView`, `ShapeableImageView`) |
| **AppCompat** | 1.7.1 | Backward compatibility |
| **AndroidX Core KTX** | 1.18.0 | Kotlin extensions untuk Android |

## Struktur Project

```
BaliTourismApp/
├── app/
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           ├── java/com/example/balitourismapp/
│           │   ├── MainActivity.kt          # Activity utama dengan RecyclerView
│           │   ├── TouristAdapter.kt        # Custom RecyclerView Adapter
│           │   └── TouristPlace.kt          # Data class model
│           └── res/
│               ├── drawable/                # Gambar destinasi wisata
│               ├── layout/
│               │   ├── activity_main.xml    # Layout utama
│               │   └── item_layout.xml      # Layout item RecyclerView
│               └── values/
│                   ├── colors.xml           # Definisi warna
│                   ├── strings.xml          # String resources
│                   └── themes.xml           # Tema aplikasi
├── build.gradle.kts                         # Root build configuration
├── settings.gradle.kts                      # Project settings
└── gradle/
    └── libs.versions.toml                   # Version catalog
```

## Arsitektur Kode

### `TouristPlace.kt` — Data Model
``` kotlin
data class TouristPlace(
    val name: String,
    val location: String,
    val description: String,
    val imageResId: Int
)
```
Data class sederhana yang merepresentasikan satu destinasi wisata.

### `TouristAdapter.kt` — RecyclerView Adapter
``` kotlin
class TouristAdapter(
    private val touristPlaces: List<TouristPlace>
) : RecyclerView.Adapter<TouristAdapter.TouristViewHolder>() {

    class TouristViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvPlaceName: TextView = itemView.findViewById(R.id.tvPlaceName)
        val tvLocation: TextView = itemView.findViewById(R.id.tvLocation)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        val imgTourist: ImageView = itemView.findViewById(R.id.imgTourist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TouristViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)

        return TouristViewHolder(view)
    }

    override fun onBindViewHolder(holder: TouristViewHolder, position: Int) {
        val place = touristPlaces[position]

        holder.tvPlaceName.text = place.name
        holder.tvLocation.text = place.location
        holder.tvDescription.text = place.description
        
        holder.imgTourist.setImageResource(place.imageResId)
    }

    override fun getItemCount(): Int {
        return touristPlaces.size
    }
}
```
Custom adapter yang mengextend `RecyclerView.Adapter` dengan `ViewHolder` pattern untuk menampilkan setiap item destinasi wisata ke dalam `MaterialCardView`.

### `MainActivity.kt` — Activity Utama
``` kotlin
class MainActivity : AppCompatActivity() {

    private lateinit var rvTouristPlaces: RecyclerView
    private lateinit var touristAdapter: TouristAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvTouristPlaces = findViewById(R.id.rvTouristPlaces)

        val touristPlaces = getTouristPlaces()

        touristAdapter = TouristAdapter(touristPlaces)

        rvTouristPlaces.layoutManager = LinearLayoutManager(this)
        rvTouristPlaces.adapter = touristAdapter
        rvTouristPlaces.setHasFixedSize(true)
    }

    private fun getTouristPlaces(): List<TouristPlace> {
        return listOf(
            TouristPlace(
                "Tanah Lot",
                "Tabanan, Bali",
                "A famous sea temple built on a rocky offshore formation, best known for its beautiful sunset views.",
                R.drawable.tanah_lot
            ),
            TouristPlace(
                "Uluwatu Temple",
                "South Kuta, Badung",
                "A cliffside Hindu temple overlooking the Indian Ocean, popular for sunset views and Kecak dance performances.",
                R.drawable.uluwatu_temple
            ),
            TouristPlace(
                "Tegallalang Rice Terrace",
                "Ubud, Gianyar",
                "A scenic rice terrace area with traditional Balinese irrigation systems and lush green landscapes.",
                R.drawable.tegallalang_rice_terrace
            ),
            TouristPlace(
                "Mount Batur",
                "Kintamani, Bangli",
                "An active volcano famous for sunrise trekking and panoramic views of Lake Batur.",
                R.drawable.mount_batur
            ),
            TouristPlace(
                "Besakih Temple",
                "Karangasem, Bali",
                "Known as the Mother Temple of Bali, this large temple complex sits on the slopes of Mount Agung.",
                R.drawable.besakih_temple
            ),
            TouristPlace(
                "Nusa Penida",
                "Klungkung, Bali",
                "A beautiful island destination known for dramatic cliffs, crystal-clear waters, and beaches like Kelingking Beach.",
                R.drawable.nusa_penida
            ),
            TouristPlace(
                "Sanur Beach",
                "Denpasar, Bali",
                "A calm coastal area suitable for sunrise viewing, cycling, family trips, and relaxing beach walks.",
                R.drawable.sanur_beach
            ),
            TouristPlace(
                "Garuda Wisnu Kencana",
                "Ungasan, Badung",
                "A cultural park featuring a massive statue of Vishnu riding Garuda, along with performances and open spaces.",
                R.drawable.garuda_wisnu_kencana
            ),
            TouristPlace(
                "Sekumpul Waterfall",
                "Buleleng, Bali",
                "One of Bali’s most impressive waterfalls, surrounded by tropical forest and natural scenery.",
                R.drawable.sekumpul_waterfall
            )
        )
    }
}
```
Activity yang menginisialisasi `RecyclerView` dengan `LinearLayoutManager` dan mengisi data 9 destinasi wisata ke adapter.

## Cara Menjalankan

### Prasyarat
- **Android Studio** (versi terbaru direkomendasikan)
- **JDK 17** atau lebih tinggi
- **Android SDK** dengan API Level 24 ke atas

### Langkah-langkah

1. **Clone repository**
   ```bash
   git clone https://github.com/Sands225/PemrogramanMobile_RecyclerView.git
   ```

2. **Buka project** di Android Studio
   ```
   File → Open → pilih folder BaliTourismApp
   ```

3. **Sync Gradle**
   Tunggu hingga proses Gradle sync selesai secara otomatis.

4. **Jalankan aplikasi**
   Klik tombol **▶ Run** atau tekan `Shift + F10`, kemudian pilih emulator atau perangkat fisik.

## Screenshot

<div align="center">

| Overview Apps |
|-------------|
<div align="center">
  <img src="app/screenshot/image.png" height="500px"/>
</div>


</div>

## Referensi Pembelajaran

- [RecyclerView - Android Developers](https://developer.android.com/develop/ui/views/layout/recyclerview)
- [Material Components - Android](https://material.io/develop/android)
- [Kotlin Data Classes](https://kotlinlang.org/docs/data-classes.html)

## Lisensi

Project ini dibuat untuk keperluan tugas kuliah **Pemrograman Mobile** dalam pemenuhan Ujian Tengah Semester.

---

</div>
