package com.example.mymuvielesson.ui.main.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Muvie(

    val name: String,
    val nameOrigin: String = "",
    val releaseDate: Date,
    var favorite: Boolean = false,
    val rating: String = "",
    val description: String = "Описание фильма",
    val genre: String = "Жанр",
    val duration: String = "",
    val budget: String = "",
    val revenue: String = ""
) : Parcelable

fun getNowPlayingMovies()=listOf(
        Muvie("Фильм 1", "Movie 1", Calendar.getInstance().time, true, "8.1"),
        Muvie("Фильм 2", "Movie 2", Calendar.getInstance().time, false, "6.8"),
        Muvie("Фильм 3", "Movie 3", Calendar.getInstance().time, true, "7.4"),
        Muvie("Фильм 4", "Movie 4", Calendar.getInstance().time, false, "5.2"),
        Muvie("Фильм 9", "Movie 4", Calendar.getInstance().time, false, "5.2"),
        Muvie("Фильм 10", "Movie 4", Calendar.getInstance().time, false, "5.2")
    )

fun getUpcomingMovies()= listOf(
        Muvie("Фильм 5", "Movie 5", Calendar.getInstance().time, false, "", "", "Фантастика"),
        Muvie("Фильм 6", "Movie 6", Calendar.getInstance().time, false, "", "", "Мелодрама"),
        Muvie("Фильм 7", "Movie 7", Calendar.getInstance().time, false, "", "", "Боевик"),
        Muvie("Фильм 8", "Movie 8", Calendar.getInstance().time, false, "", "", "Триллер"),
        Muvie("Фильм 11", "Movie 8", Calendar.getInstance().time, false, "", "", "Комедия"),
        Muvie("Фильм 12", "Movie 8", Calendar.getInstance().time, false, "", "", "Документальный")
    )
