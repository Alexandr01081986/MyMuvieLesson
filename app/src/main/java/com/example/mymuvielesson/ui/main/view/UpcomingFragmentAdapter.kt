package com.example.mymuvielesson.ui.main.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymuvielesson.R
import com.example.mymuvielesson.ui.main.model.Muvie

class UpcomingFragmentAdapter : RecyclerView.Adapter<UpcomingFragmentAdapter.ViewHolder>() {

    internal var movieData: List<Muvie> = emptyList()

    private var itemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_upcoming, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieData[position])
    }

    override fun getItemCount(): Int {
        return movieData.size
    }

    fun interface OnItemClickListener {
        fun onItemClick(movie: Muvie)
    }

    fun setOnItemClickListener(itemClickListener: OnItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movie: Muvie) {
            itemView.apply {
                findViewById<TextView>(R.id.title_upcome).text = movie.name
                findViewById<TextView>(R.id.date_upcome).text =movie.releaseDate.format()
                findViewById<TextView>(R.id.genre_item).text = movie.genre
            }.also {
                it.findViewById<CardView>(R.id.card_come).setOnClickListener {
                    itemClickListener?.onItemClick(movie)
                }
                it.findViewById<AppCompatImageView>(R.id.image_view_come).setOnClickListener {
                    itemClickListener?.onItemClick(movie)
                }
            }
        }
    }
}