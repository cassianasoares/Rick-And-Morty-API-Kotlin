package com.demo.android.cassiana.rickandmortycardapp.fragment.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.android.cassiana.rickandmortycardapp.R
import com.demo.android.cassiana.rickandmortycardapp.model.Character
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*

class CharacterAdpater: RecyclerView.Adapter<CharacterAdpater.CharacterViewHolder>() {

    private var listCharacters = emptyList<Character>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(listCharacters[position])
    }

    override fun getItemCount(): Int {
        return listCharacters.size
    }

    fun getCharacters(characters: List<Character>){
        listCharacters = characters
        notifyDataSetChanged()
    }

    class CharacterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var image_character = itemView.character_img
        //var image_status = itemView.status_icon
        var id_number = itemView.txt_id_character
        var name_character = itemView.txt_name_character

        fun bind(character: Character){
            Picasso.get().load(character.image).into(image_character)
            id_number.text = character.id.toString()
            name_character.text = character.name
        }
    }

}