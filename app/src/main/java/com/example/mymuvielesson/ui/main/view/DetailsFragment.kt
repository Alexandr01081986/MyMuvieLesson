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

        arguments?.getParcelable<Muvie>(BUNDLE_EXTRA)?.let { initView(it) }
    }

    private fun initView(muvie: Muvie) {
        with(binding) {
            titleRus.text = muvie.name
            titleOriginal.text = muvie.nameOrigin
            genre.text = muvie.genre
            duration.apply { text = muvie.duration }.hideIf { muvie.duration == "" }
            ratingDetail.text = muvie.rating
            revenue.apply { text = muvie.revenue }.showIf { muvie.revenue != "" }
            description.text = muvie.description
            dateRelease.text = muvie.releaseDate.format()
            btnFavorite.setBackgroundResource(
                changeBackButton(muvie.favorite)
            )
            btnFavorite.setOnClickListener {
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