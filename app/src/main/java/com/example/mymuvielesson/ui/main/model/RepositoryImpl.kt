package com.example.mymuvielesson.ui.main.model

import java.util.*

class RepositoryImpl : Repository {

    override fun getMoviesFromServer(): Muvie {
        return Muvie("Фильм из сервера","Movie Server", Calendar.getInstance().time)
    }

    override fun getNowPlayingFromLocalStorage(): List<Muvie> {
        return getNowPlayingMovies()
    }

    override fun getUpcomingFromLocalStorage(): List<Muvie> {
        return getUpcomingMovies()
    }

}