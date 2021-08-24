package com.example.mymuvielesson.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import android.widget.Toast
import com.example.mymuvielesson.R
import com.example.mymuvielesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initButtons()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.container.id, MainFragment.newInstance())
                .commitNow()
        }
    }

    private fun initButtons() {
        binding.btnHome.setOnCheckedChangeListener { buttonView, isChecked ->
            buttonView.setBackgroundResource(
                when {
                    isChecked -> R.drawable.ic_baseline_home_20
                    else  -> R.drawable.ic_baseline_home_20_off
                })
        }
        binding.btnFavorite.setOnCheckedChangeListener { buttonView, isChecked ->
            buttonView.setBackgroundResource(
                when {
                    isChecked -> R.drawable.ic_baseline_star_border_20
                    else  -> R.drawable.ic_baseline_star_border_20_off
                })
        }
        binding.btnRating.setOnCheckedChangeListener { buttonView, isChecked ->
            buttonView.setBackgroundResource(
                when {
                    isChecked -> R.drawable.ic_baseline_graphic_eq_20
                    else  -> R.drawable.ic_baseline_graphic_eq_20_off
                })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val search = menu?.findItem(R.id.action_search)
        val searchText = search?.actionView as SearchView
        searchText.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(this@MainActivity, query, Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return true
            }
        })
        return true
    }
}