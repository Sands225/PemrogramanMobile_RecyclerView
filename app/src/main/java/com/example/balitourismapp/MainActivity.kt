package com.example.balitourismapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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