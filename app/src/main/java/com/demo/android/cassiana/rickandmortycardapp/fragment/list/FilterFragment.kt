package com.demo.android.cassiana.rickandmortycardapp.fragment.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.CheckBox
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.demo.android.cassiana.rickandmortycardapp.R
import com.demo.android.cassiana.rickandmortycardapp.model.Character
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.fragment_filter.*


class FilterFragment : Fragment(R.layout.fragment_filter) {
    private val mainViewModel: ListViewModel by activityViewModels()
    var teste = listOf<Character>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val size_group = clipGroup_teste.checkedChipIds
//
//
//
//            one.setOnClickListener {
//                one.setChecked(!one.isChecked)
//                if(one.isChecked){
//                    img_male.setImageResource(R.drawable.ic_chip_icon_teste)
//                }else{
//                    img_male.setImageResource(R.drawable.ic_chip_icon)
//                }
//            }
//
//        two.setOnClickListener {
//            two.setChecked(!two.isChecked)
//            if(two.isChecked){
//                img_male_two.setImageResource(R.drawable.ic_chip_icon_teste)
//            }else{
//                img_male_two.setImageResource(R.drawable.ic_chip_icon)
//            }
//        }

        btn_make_filter.setOnClickListener {
            getSelect(mainViewModel.allCharacters.value!!)
            //mainViewModel.orderBy(mainViewModel.allCharacters.value!!)
            //Log.d("SizeGroup", size_group.size.toString())

            findNavController().navigate(R.id.action_filterFragment_to_listFragment)
        }
    }

    fun getSelect(list: List<Character>) {
//        clipGroup_status.forEach { child ->
//            (child as? Chip)?.setOnCheckedChangeListener { _, _ ->
//                Toast.makeText(context, "Selected Clip", Toast.LENGTH_LONG).show()
//            }
//        }
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
    }

}