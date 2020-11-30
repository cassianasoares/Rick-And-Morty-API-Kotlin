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
        val chip = findViewById<Chip>(selectedId).text.toString()
        return chip
    }
}

fun RadioGroup.getTextButtonChecked(): String{
    val selectedId: Int = this.checkedRadioButtonId
    if(selectedId == -1){
        return " "
    }else{
        val radioButton = findViewById<RadioButton>(selectedId).text.toString()
        return radioButton
    }
}
