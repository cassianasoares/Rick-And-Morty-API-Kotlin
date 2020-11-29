package com.demo.android.cassiana.rickandmortycardapp.fragment.filter

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.CheckBox
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.demo.android.cassiana.rickandmortycardapp.R
import com.demo.android.cassiana.rickandmortycardapp.fragment.SharedViewModel
import com.demo.android.cassiana.rickandmortycardapp.model.Character
import com.demo.android.cassiana.rickandmortycardapp.util.Util
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.fragment_filter.*


class FilterFragment : Fragment(R.layout.fragment_filter) {
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       val checkboxList = listOf<CheckBox>(checkbox_female,checkbox_genderless, checkbox_male, checkbox_unknown)

        btn_make_filter.setOnClickListener {
            val titles = Util.getAllTitles(clipGroup_status, clipGroup_n_episodes, checkboxList)
            viewModel.setFilter(viewModel.allCharacters.value!!, titles)

            findNavController().navigate(R.id.action_filterFragment_to_listFragment)
        }
    }

//    fun getSelect(list: List<Character>) {
//        val idsStatus = clipGroup_status//.checkedChipIds
//        val idsGender = clipGroup_gender//.checkedChipIds
//        val listCheckBox = listOf<CheckBox>()
//        val listClipsIds = listOf<Any>(idsStatus, idsGender, listCheckBox)
//        val sentensa = mutableListOf<Character>()
//        sentensa.addAll(list)
//
//        listCheckBox.forEach{}
//        //val types = arrayOf("status", "gender")
//        //val characters = arrayListOf<Character>()
//
//        for (index in 0..1) {
//
//                var listFinal = listOf<Character>()
//                val titles = mutableListOf<CharSequence>()
//
//                listClipsIds[index].checkedChipIds.forEach { id ->
//                    titles.add(listClipsIds[index].findViewById<Chip>(id).text)
//                }
//                //val texto = titles.toString().replace(",", " ||")
//                Log.d("idsClip", titles.toString())
//                //Log.d("texto", "it.${types[index]}")
//                listFinal = (when(index){
//                   0 -> mainViewModel.orderByStatus(sentensa, titles)
//                   else-> mainViewModel.orderByGender(sentensa, titles)
//                })
//
//                Log.d("listFinal", listFinal.size.toString())
//
//                if(listFinal.isNotEmpty()) {
//                    sentensa.clear()
//                    sentensa.addAll(listFinal)
//                }
//                Log.d("texto", sentensa.size.toString())
//
//        }
//
////        //Log.d("idsClip", sentensa.toString().replace(",", " &&"))
//        if(sentensa.size == 60) { sentensa.clear()}
//            mainViewModel.filterCharacters.value = sentensa
//
//       // mainViewModel.orderBy(list, listTitles)
//    }

}