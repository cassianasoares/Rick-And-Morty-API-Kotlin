package com.demo.android.cassiana.rickandmortycardapp.extensions

import android.widget.RadioButton
import android.widget.RadioGroup
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

fun ChipGroup.getTextChipChecked(): String{
    val selectedId: Int = this.checkedChipId
    if(selectedId == -1){
        return " "
    }else{
        return findViewById<Chip>(selectedId).text.toString()
    }
}

    fun RadioGroup.getTextButtonChecked(): String {
        val selectedId: Int = this.checkedRadioButtonId
        if (selectedId == -1) {
            return " "
        } else {
            return findViewById<RadioButton>(selectedId).text.toString()
        }
    }

    fun RadioGroup.setButtonChecked(selectedId: Int) {
        if (selectedId == -1) {
            return
        } else {
            this.findViewById<RadioButton>(selectedId).isChecked = true
        }
    }
