package com.example.rickandmortyapi.api

import com.example.rickandmortyapi.model.CharacterList

class Repository {
    suspend fun getAllCharacters() : CharacterList {
        return RetrofitInstance.api.getAllCharacters()
    }
}