package com.demo.android.cassiana.rickandmortycardapp.util

import android.widget.CheckBox
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

object Util {

    fun getAllTitles(chipStatus: ChipGroup, chipEpisodes: ChipGroup, checkboxes: List<CheckBox>): ArrayList<List<String>>{
        return arrayListOf(getTitlesStatus(chipStatus), setEpisodes(chipEpisodes), getGender(checkboxes))
    }

    private fun getTitlesStatus(chipList: ChipGroup): List<String> {
        val titles = arrayListOf<String>()
        chipList.checkedChipIds.forEach { id ->
            titles.add(chipList.findViewById<Chip>(id).text.toString())
        }
        return titles
    }

    private fun setEpisodes(chip: ChipGroup): List<String> {
        val titles = arrayListOf<String>()
        chip.checkedChipIds.forEach { id ->
            val interval = chip.findViewById<Chip>(id).text.toString()
            if (interval.isNotEmpty()) {
                for (number in getNumbers(interval)) {
                    titles.add(number)
                }
            }
        }
        return titles
     }

    private fun getGender(checkboxList: List<CheckBox>):List<String> {
        val titles = arrayListOf<String>()
        checkboxList.forEach { checkbox ->
            if (checkbox.isChecked) {
                titles.add(checkbox.text.toString())
            }
        }
        return titles
    }

    private fun getNumbers(text: String): List<String>{
        return text.split("-")
    }

}