package com.example.rickandmortyapi.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmortyapi.api.Repository

class SharedViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SharedViewModel() as T
    }
}