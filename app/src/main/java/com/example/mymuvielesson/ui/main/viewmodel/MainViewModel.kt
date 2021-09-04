package com.example.mymuvielesson.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymuvielesson.ui.main.model.Repository
import com.example.mymuvielesson.ui.main.model.RepositoryImpl
import java.lang.Thread.sleep

class MainViewModel(
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val repositoryImpl: Repository = RepositoryImpl()
) : ViewModel() {

    // Получаем данные
    fun getLiveData() = liveDataToObserve

    fun getDataFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(1000)
            liveDataToObserve.postValue(
                AppState.Success(
                    repositoryImpl.getNowPlayingFromLocalStorage(),
                    repositoryImpl.getUpcomingFromLocalStorage()
                )
            )
        }.start()
    }
}