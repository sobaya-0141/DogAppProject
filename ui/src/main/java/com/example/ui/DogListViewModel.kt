
package com.example.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.data.Repository
import com.example.model.DogBreed

class DogListViewModel(private val repository: Repository) : ViewModel() {
    private val _dogBreeds = MutableLiveData<List<String>>()
    val dogBreeds: LiveData<List<String>> get() = _dogBreeds

    fun loadDogBreeds() {
        viewModelScope.launch {
            val response = repository.fetchDogBreeds()
            if (response.status == "success") {
                _dogBreeds.value = response.message
            }
        }
    }
}
    