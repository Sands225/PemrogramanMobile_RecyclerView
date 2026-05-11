package com.example.balitourismapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TouristAdapter(
    private val touristPlaces: List<TouristPlace>
) : RecyclerView.Adapter<TouristAdapter.TouristViewHolder>() {

    class TouristViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvPlaceName: TextView = itemView.findViewById(R.id.tvPlaceName)
        val tvLocation: TextView = itemView.findViewById(R.id.tvLocation)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
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
    }

    override fun getItemCount(): Int {
        return touristPlaces.size
    }
}