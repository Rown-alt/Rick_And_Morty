package com.example.rickandmortyapi.recyclerview

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.model.Character
import com.squareup.picasso.Picasso

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.CharacterViewHolder>()
{
    var listCharacters = emptyList<Character>()
    class CharacterViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val image : ImageView
        val name : TextView
        val type : TextView

        init {
            image = view.findViewById(R.id.characterImag)
            name = view.findViewById(R.id.characterNam)
            type = view.findViewById(R.id.characterTyp)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list,parent,false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val curCharacter = listCharacters[position]
        with(holder){
            name.text = curCharacter.name
            type.text = curCharacter.type
            Picasso.get().load(curCharacter.imageUrl).into(image)
        }
    }

    override fun getItemCount(): Int {
        return listCharacters.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCharacters(characters: List<Character>){
        listCharacters = characters
        notifyDataSetChanged()
    }

}