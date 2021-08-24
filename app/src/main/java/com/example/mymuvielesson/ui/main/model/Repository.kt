package com.example.mymuvielesson.ui.main.model



interface Repository {
    fun getMoviesFromServer(): Muvie
    fun getNowPlayingFromLocalStorage(): List<Muvie>
    fun getUpcomingFromLocalStorage(): List<Muvie>
}