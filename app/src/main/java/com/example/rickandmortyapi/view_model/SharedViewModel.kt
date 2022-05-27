package com.example.rickandmortyapi.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapi.api.RetrofitInstance
import com.example.rickandmortyapi.model.Character
import kotlinx.coroutines.launch

class SharedViewModel() : ViewModel() {
    var character = MutableLiveData<Character>()
    var charactersInEpisode = MutableLiveData<List<Character>>()
    fun getCharacters(page: Int) {
        viewModelScope.launch {
                RetrofitInstance.api.getCharacters(page).onSuccess {
                    charactersInEpisode.value = it.results
                }
            for (i in 2..42){
                RetrofitInstance.api.getCharacters(i).onSuccess {
                    charactersInEpisode.value =
                        charactersInEpisode.value!! + it.results
                }
        }
        }
    }
    fun getCharacterById(id : Int){
        viewModelScope.launch {
            RetrofitInstance.api.getCharacterById(id).onSuccess {
                character.value = it
            }
        }
    }
}