package com.example.rickandmortyapi.api

import com.example.rickandmortyapi.model.CharacterList
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleApi {
    @GET("/character")
    suspend fun getAllCharacters(): CharacterList{
        return RetrofitInstance.api.getAllCharacters()
    }

}