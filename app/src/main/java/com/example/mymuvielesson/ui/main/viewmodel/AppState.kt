package com.example.mymuvielesson.ui.main.viewmodel

import com.example.mymuvielesson.ui.main.model.Muvie


sealed class AppState {
    data class Success(val movieDataPlay: List<Muvie>, val movieDataCome: List<Muvie>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}