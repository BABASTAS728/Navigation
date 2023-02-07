package com.example.navigation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigation.R
import com.example.navigation.domain.Repository
import com.example.navigation.domain.models.UiItem
import com.example.navigation.domain.use_cases.GetLowRatingFilmsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _liveData = MutableLiveData<List<UiItem>>()
    val liveData: LiveData<List<UiItem>> get() = _liveData

    private val _errorLiveData = MutableLiveData<Int>()
    val errorLiveData: LiveData<Int> get() = _errorLiveData

    private val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> get() = _loadingLiveData

    private val handler= CoroutineExceptionHandler{ _, throwable: Throwable ->
      when(throwable){
          is SocketTimeoutException -> _errorLiveData.value = R.string.socketTimeoutException
          else -> _errorLiveData.value = R.string.otherExceptions
      }
    }

    fun getFilms() {
        viewModelScope.launch(handler) {
            _loadingLiveData.value = false
            _liveData.value = repository.getFilmsList()
        }
    }

    fun getLowRatingFilms() {
        viewModelScope.launch(handler) {
            val useCase = GetLowRatingFilmsUseCase(repository)
            _liveData.value = useCase.invoke()
        }
    }
}