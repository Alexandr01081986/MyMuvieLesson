package com.example.mymuvielesson.ui.main.model

import java.util.*

class RepositoryImpl : Repository {

    override fun getMoviesFromServer()= Muvie(
        "Фильм из сервера","Movie Server", Calendar.getInstance().time)
    override fun getNowPlayingFromLocalStorage() = getNowPlayingMovies()
    override fun getUpcomingFromLocalStorage() = getUpcomingMovies()
}