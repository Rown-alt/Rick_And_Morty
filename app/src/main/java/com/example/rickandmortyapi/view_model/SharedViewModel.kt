package com.example.rickandmortyapi.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapi.api.Repository
import com.example.rickandmortyapi.api.RetrofitInstance
import com.example.rickandmortyapi.model.Character
import kotlinx.coroutines.launch

class SharedViewModel() : ViewModel() {

    var charactersInEpisode = MutableLiveData<List<Character>>()
    fun getCharacters(page: Int) {
        viewModelScope.launch {
                charactersInEpisode.value = RetrofitInstance.api.getCharacters(page).results
            for (i in 1..42){
                charactersInEpisode.value =
                    charactersInEpisode.value!! + RetrofitInstance.api.getCharacters(i).results

        }
        }
    }
}