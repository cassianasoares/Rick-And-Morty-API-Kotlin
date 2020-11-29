package com.demo.android.cassiana.rickandmortycardapp.fragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.android.cassiana.rickandmortycardapp.Repository
import com.demo.android.cassiana.rickandmortycardapp.model.Character
import kotlinx.coroutines.launch

class SharedViewModel: ViewModel() {

    private val repository = Repository()
    var allCharacters = MutableLiveData<List<Character>>()
    var filterCharacters = MutableLiveData<List<Character>>()

    fun getCharacters(pages: Array<Int>) {
        val characters= arrayListOf<Character>()
        for (page in pages){
            viewModelScope.launch{
                val response = repository.getCharacters(page)
                characters.addAll(response.results)
                allCharacters.value = characters.sortedBy { it.id }
            }
       }
    }

    fun setFilter(list: List<Character>, titles: ArrayList<List<String>>){

        val sentensa = mutableListOf<Character>()
        sentensa.addAll(list)

        Log.d("IndicexTitle",  titles.toString())
        for (index in titles.indices) {

            if(titles[index].isNotEmpty()) {

                val listFinal = (when (index) {
                    0 -> orderByStatus(sentensa, titles[index])
                    1 -> orderByEpisodesNumbers(sentensa, titles[index])
                    else -> orderByGender(sentensa, titles[index])
                })

                Log.d("listFinal", listFinal.size.toString())

                    sentensa.clear()
                    sentensa.addAll(listFinal.sortedBy { it.id })

                Log.d("texto", sentensa.size.toString())
            }
        }
            filterCharacters.value = sentensa
    }

    fun orderByStatus(list: List<Character>, condition: List<String>): List<Character>{
        val characters = arrayListOf<Character>()
        for(item in condition) {
            //Log.d("RecebidoView", item.toString())
            characters.addAll(list.filter { it.status == item })
        }
        Log.d("Filter", characters.size.toString())
        return characters//.sortedBy { it.id }
    }

    fun orderByEpisodesNumbers(list: List<Character>, condition: List<String>): List<Character>{
        val characters = arrayListOf<Character>()
        //Log.d("RecebidoView", item.toString())
        characters.addAll(list.filter { it.episode.size in condition[0].toInt()..condition[1].toInt()})
        Log.d("Filter", characters.size.toString())
        return characters//.sortedBy { it.id }
    }

    fun orderByGender(list: List<Character>, condition: List<String>): List<Character>{
        val characters = arrayListOf<Character>()
        for(item in condition) {
            characters.addAll(list.filter { it.gender == item })
        }
        Log.d("Filter", characters.size.toString())
        return characters//.sortedBy { it.id }
    }

}