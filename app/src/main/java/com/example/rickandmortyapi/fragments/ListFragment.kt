package com.example.rickandmortyapi.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapi.R
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.rickandmortyapi.api.Repository
import com.example.rickandmortyapi.recyclerview.RecyclerAdapter
import com.example.rickandmortyapi.view_model.SharedViewModel
import com.example.rickandmortyapi.view_model.SharedViewModelFactory

class ListFragment : Fragment(R.layout.character_list) {
    private val viewModel: SharedViewModel by activityViewModels{ SharedViewModelFactory(Repository()) }
    val adapter = RecyclerAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.charactersInEpisode.observe(viewLifecycleOwner) {
            adapter.setCharacters(it)
        }
        val recyclerView : RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter = adapter
    }
}