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
                "A famous sea temple built on a rocky offshore formation, best known for its beautiful sunset views."
            ),
            TouristPlace(
                "Uluwatu Temple",
                "South Kuta, Badung",
                "A cliffside Hindu temple overlooking the Indian Ocean, popular for sunset views and Kecak dance performances."
            ),
            TouristPlace(
                "Tegallalang Rice Terrace",
                "Ubud, Gianyar",
                "A scenic rice terrace area with traditional Balinese irrigation systems and lush green landscapes."
            ),
            TouristPlace(
                "Kuta Beach",
                "Kuta, Badung",
                "One of Bali’s most popular beaches, known for surfing, nightlife, shopping, and golden sunsets."
            ),
            TouristPlace(
                "Mount Batur",
                "Kintamani, Bangli",
                "An active volcano famous for sunrise trekking and panoramic views of Lake Batur."
            ),
            TouristPlace(
                "Besakih Temple",
                "Karangasem, Bali",
                "Known as the Mother Temple of Bali, this large temple complex sits on the slopes of Mount Agung."
            ),
            TouristPlace(
                "Nusa Penida",
                "Klungkung, Bali",
                "A beautiful island destination known for dramatic cliffs, crystal-clear waters, and beaches like Kelingking Beach."
            ),
            TouristPlace(
                "Sanur Beach",
                "Denpasar, Bali",
                "A calm coastal area suitable for sunrise viewing, cycling, family trips, and relaxing beach walks."
            ),
            TouristPlace(
                "Garuda Wisnu Kencana",
                "Ungasan, Badung",
                "A cultural park featuring a massive statue of Vishnu riding Garuda, along with performances and open spaces."
            ),
            TouristPlace(
                "Sekumpul Waterfall",
                "Buleleng, Bali",
                "One of Bali’s most impressive waterfalls, surrounded by tropical forest and natural scenery."
            ),
            TouristPlace(
                "Ulun Danu Beratan Temple",
                "Bedugul, Tabanan",
                "A beautiful lakeside temple located on Lake Beratan, often appearing as if floating on the water."
            ),
            TouristPlace(
                "Campuhan Ridge Walk",
                "Ubud, Gianyar",
                "A peaceful walking trail with green hills, fresh air, and scenic views near central Ubud."
            ),
            TouristPlace(
                "Jimbaran Beach",
                "Jimbaran, Badung",
                "A beach destination famous for seafood restaurants, calm waters, and romantic sunset dinners."
            ),
            TouristPlace(
                "Tirta Empul Temple",
                "Tampaksiring, Gianyar",
                "A sacred water temple known for its holy spring purification ritual and traditional Balinese architecture."
            ),
            TouristPlace(
                "Bali Safari and Marine Park",
                "Gianyar, Bali",
                "A family-friendly wildlife park featuring animal shows, safari journeys, and educational attractions."
            )
        )
    }
}