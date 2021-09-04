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

class NowPlayingFragmentAdapter : RecyclerView.Adapter<NowPlayingFragmentAdapter.ViewHolder>() {

    internal var movieData: List<Muvie> = emptyList()

    private var onSomeItemClickListener: ((Muvie) -> Unit)? = null

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

    fun setOnItemClickListener(onSomeItemClickListener: (Muvie) -> Unit) {
        this.onSomeItemClickListener = onSomeItemClickListener

        fun removeListener() {
            onSomeItemClickListener = null
        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            fun bind(movie: Muvie) {
                itemView.apply {
                    findViewById<TextView>(R.id.title_play).text = movie.name
                    findViewById<TextView>(R.id.rating).text = movie.rating
                    findViewById<TextView>(R.id.date_play).text = movie.releaseDate.format()
                    findViewById<CardView>(R.id.card_play).setOnClickListener {
                        onSomeItemClickListener?.invoke(movie)
                    }
                    val imageMovie = findViewById<AppCompatImageView>(R.id.image_view_play)
                    imageMovie.createImageFromResource()
                    imageMovie.setOnClickListener {
                        onSomeItemClickListener?.invoke(movie)
                    }
                }
            }
        }
    }
}