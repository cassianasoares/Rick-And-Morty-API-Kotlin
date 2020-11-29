package com.demo.android.cassiana.rickandmortycardapp.fragment.details



import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.demo.android.cassiana.rickandmortycardapp.R
import com.demo.android.cassiana.rickandmortycardapp.fragment.details.DetailFragmentArgs
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_detail.txt_status

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val character = args.character

        txt_id_character.text= character.id.toString()
        txt_status.text= character.status
        Picasso.get().load(character.image).into(img_character)
        txt_name.text= character.name
        txt_specie.text = character.species
        txt_gender.text = character.gender
        txt_n_episodes.text = character.episode.size.toString()
        txt_origin.text= character.origin.name
        txt_location.text= character.location.name

    }

}