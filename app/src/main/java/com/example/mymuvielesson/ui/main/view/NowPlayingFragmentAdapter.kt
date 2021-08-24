package com.example.mymuvielesson.ui.main.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymuvielesson.R
import com.example.mymuvielesson.ui.main.model.Muvie

class NowPlayingFragmentAdapter : RecyclerView.Adapter<NowPlayingFragmentAdapter.ViewHolder>() {

    private var movieData: List<Muvie> = emptyList()
    private var itemClickListener: OnItemClickListener? = null

    fun setData(data: List<Muvie>) {
        movieData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_now_playing, parent, false) as View
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

    fun removeListener() {
        itemClickListener = null
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movie: Muvie) {
            itemView.findViewById<TextView>(R.id.title_play).text = movie.name
            itemView.findViewById<TextView>(R.id.rating).text = movie.rating
            itemView.findViewById<TextView>(R.id.date_play).text = movie.releaseDate.toString()
            itemView.findViewById<AppCompatImageView>(R.id.image_view_play).setOnClickListener {
                itemClickListener?.onItemClick(movie)
            }
        }
    }
}