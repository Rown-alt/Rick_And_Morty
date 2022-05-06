package com.example.rickandmortyapi.fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.rickandmortyapi.R
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class CharacterFragment : Fragment(R.layout.details) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args : CharacterFragmentArgs by navArgs()

        val character = args.character

        val name : TextView = view.findViewById(R.id.characterName_Details)
        val type : TextView = view.findViewById(R.id.characterType_Details)
        val id : TextView = view.findViewById(R.id.characterID_Details)
        val location : TextView = view.findViewById(R.id.characterLocation_Details)
        val gender : TextView = view.findViewById(R.id.characterGender_Details)
        val status : TextView = view.findViewById(R.id.characterStatus_Details)
        val species : TextView = view.findViewById(R.id.characterSpecies_Details)
        val origin : TextView = view.findViewById(R.id.characterOrigin_Details)
        val episode : TextView = view.findViewById(R.id.characterEpisode_Details)
        val image : ImageView = view.findViewById(R.id.characterImage_Details)

        id.text = character.id.toString()
        status.text = character.status
        type.text = character.type
        name.text = character.name
        location.text = character.location.name
        gender.text = character.gender
        species.text = character.species
        origin.text = character.origin.name
        episode.text = character.episode.toString()
        Picasso.get().load(character.image).into(image)

    }
}