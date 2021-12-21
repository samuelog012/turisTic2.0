package com.example.turistic20.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.turistic20.R
import com.example.turistic20.model.SpotsItem
import com.squareup.picasso.Picasso

class SpotsAdapter(
    private val spotsList: ArrayList<SpotsItem>,
    private val onItemClicked: (SpotsItem) -> Unit
) : RecyclerView.Adapter<SpotsAdapter.SpotsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_spots, parent, false)
        return SpotsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpotsViewHolder, position: Int) {
        val spots = spotsList[position]
        holder.itemView.setOnClickListener { onItemClicked(spotsList[position]) }
        holder.bind(spots)
    }

    override fun getItemCount(): Int = spotsList.size

    class SpotsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        private var direccionTextView: TextView = itemView.findViewById(R.id.direccion_text_view)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)

        fun bind(spots: SpotsItem){
            nameTextView.text = spots.name
            direccionTextView.text = spots.direccion
            Picasso.get().load(spots.urlPicture).into(pictureImageView)
        }
    }
}