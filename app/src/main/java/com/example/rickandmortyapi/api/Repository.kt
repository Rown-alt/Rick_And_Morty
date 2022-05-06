package com.example.rickandmortyapi.api

import com.example.rickandmortyapi.model.CharacterList

class Repository {
    suspend fun getCharacters(page : Int) : CharacterList {
        return RetrofitInstance.api.getCharacters(page)
    }
}