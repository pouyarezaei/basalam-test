package com.github.pouyarezaei.basalam_t1.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.pouyarezaei.basalam_t1.data.domain.InformationDomainModel
import com.github.pouyarezaei.basalam_t1.data.remote.NoConnectivityException
import com.github.pouyarezaei.basalam_t1.repository.Repository
import com.github.pouyarezaei.basalam_t1.util.TAG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val basalamRepository: Repository,
) :
    ViewModel() {
    private val networkState: MutableLiveData<Boolean> = MutableLiveData()
    private val data: MutableLiveData<MutableList<List<InformationDomainModel>>> = MutableLiveData()

    init {
        Log.d(TAG, "MainViewModel: init")
    }

    fun handleEvent(event: MainEvent) {
        when (event) {
            MainEvent.Load -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        val animalPairFlower = basalamRepository.getAnimalPairFlower()
                        networkState.postValue(true)
                        data.postValue(animalPairFlower)
                    } catch (e: NoConnectivityException) {
                        networkState.postValue(false)
                    }
                }
            }
        }
    }

    fun observeData(): LiveData<MutableList<List<InformationDomainModel>>> {
        return data
    }

    fun observeNetworkState(): LiveData<Boolean> {
        return networkState
    }
}