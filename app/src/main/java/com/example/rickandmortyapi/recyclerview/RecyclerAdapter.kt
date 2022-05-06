package com.example.rickandmortyapi.recyclerview

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.fragments.ListFragmentDirections
import com.example.rickandmortyapi.model.Character
import com.squareup.picasso.Picasso

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.CharacterViewHolder>()
{
    private var listCharacters : List<Character> = listOf()
    class CharacterViewHolder (view: View) : RecyclerView.ViewHolder(view){
        private val image : ImageView = view.findViewById(R.id.characterImage)
        private val name : TextView = view.findViewById(R.id.characterName)
        private val type : TextView = view.findViewById(R.id.characterType)
        fun bind(character: Character){
            Picasso.get().load(character.image).into(image)
            type.text = character.status
            name.text = character.name
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        Log.e("AAA", "abc")
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list,parent,false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(listCharacters[position])

        holder.itemView.setOnClickListener { view ->
            val action = ListFragmentDirections.actionListFragmentToCharacterFragment(listCharacters[position])
            view.findNavController().navigate(action)
        }
    }


    override fun getItemCount(): Int {
        return listCharacters.size
    }

    fun setCharacters(characters: List<Character>){
        this.listCharacters = characters
        Log.e("AAA","DataSet")
        notifyDataSetChanged()
    }

}

