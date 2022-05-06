package com.example.rickandmortyapi.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapi.R
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.rickandmortyapi.api.SimpleApi
import com.example.rickandmortyapi.model.Character
import com.example.rickandmortyapi.recyclerview.RecyclerAdapter
import com.example.rickandmortyapi.view_model.SharedViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListFragment : Fragment(R.layout.character_list) {
    private var adapter =  RecyclerAdapter()
    private lateinit var recyclerView: RecyclerView
    private val viewModel: SharedViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rvCharacter)
        viewModel.charactersInEpisode.observe(viewLifecycleOwner){
            adapter.setCharacters(it)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel.getCharacters(1)
    }
}