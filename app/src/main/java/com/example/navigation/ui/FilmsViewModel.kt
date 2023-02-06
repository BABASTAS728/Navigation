package com.example.navigation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.navigation.domain.Repository
import com.example.navigation.domain.UiItem
import com.example.navigation.domain.use_cases.GetLowRatingFilmsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _liveData = MutableLiveData<List<UiItem>>()
    val liveData: LiveData<List<UiItem>> get() = _liveData

    fun getFilms() {
        _liveData.value = repository.getFilmsList()
    }

    fun getLowRatingFilms() {
        val useCase = GetLowRatingFilmsUseCase(repository)
        _liveData.value = useCase()
    }
}