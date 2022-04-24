package com.example.rickandmortyapi.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapi.api.Repository
import com.example.rickandmortyapi.model.Character
import kotlinx.coroutines.launch

class SharedViewModel(private val repository: Repository) : ViewModel() {

    val charactersInEpisode = MutableLiveData<List<Character>>()

    fun getAllCharacters(){
        viewModelScope.launch {
            val characters = repository.getAllCharacters()
            charactersInEpisode.value = characters.characters
        }
    }

}