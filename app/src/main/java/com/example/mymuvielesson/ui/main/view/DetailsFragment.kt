package com.example.mymuvielesson.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mymuvielesson.R
import com.example.mymuvielesson.databinding.FragmentDetailsBinding
import com.example.mymuvielesson.ui.main.model.Muvie

class DetailsFragment : Fragment() {

    companion object {
        const val BUNDLE_EXTRA = "movie"
        fun newInstance(bundle: Bundle) = DetailsFragment().apply { arguments = bundle }
    }

    private var _binding: FragmentDetailsBinding? = null

    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val muvie = arguments?.getParcelable<Muvie>(BUNDLE_EXTRA)

        muvie?.let {
            binding.titleRus.text = muvie.name
            binding.titleOriginal.text = muvie.nameOrigin
            binding.genre.text = muvie.genre
            binding.duration.text = muvie.duration
            binding.ratingDetail.text = muvie.rating
            binding.revenue.text = muvie.revenue
            binding.description.text = muvie.description
            binding.dateRelease.text = muvie.releaseDate.toString()
            binding.btnFavorite.setBackgroundResource(
                changeBackButton(muvie.favorite)
            )
            binding.btnFavorite.setOnClickListener {
                val favorite = !muvie.favorite
                binding.btnFavorite.setBackgroundResource(changeBackButton(favorite))
                muvie.favorite = favorite
            }
        }
    }

    private fun changeBackButton(favorite: Boolean) = when {
        favorite -> R.drawable.ic_baseline_favorite_16
        else -> R.drawable.ic_baseline_favorite_border_16
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}