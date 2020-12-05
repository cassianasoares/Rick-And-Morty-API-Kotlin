package com.demo.android.cassiana.rickandmortycardapp.ui.fragment.filter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.demo.android.cassiana.rickandmortycardapp.R
import com.demo.android.cassiana.rickandmortycardapp.api.Repository
import com.demo.android.cassiana.rickandmortycardapp.extensions.getTextButtonChecked
import com.demo.android.cassiana.rickandmortycardapp.extensions.getTextChipChecked
import com.demo.android.cassiana.rickandmortycardapp.extensions.setButtonChecked

import com.demo.android.cassiana.rickandmortycardapp.ui.fragment.SharedViewModel
import com.demo.android.cassiana.rickandmortycardapp.ui.fragment.SharedViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_filter.*
import kotlinx.android.synthetic.main.fragment_list.*


class FilterFragment : BottomSheetDialogFragment() {
    private val viewModel: SharedViewModel by activityViewModels{SharedViewModelFactory(Repository())}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.filterValue.observe(viewLifecycleOwner, {
            //chipgroup_status.setChipChecked(it[0])
            radiogroup_gender.setButtonChecked(it[1])
        })

        btn_make_filter.setOnClickListener {
            if(chipgroup_status.getTextChipChecked().isNotEmpty() && radiogroup_gender.getTextButtonChecked().isNotEmpty()) {
                viewModel.getByStatusAndGender(chipgroup_status.getTextChipChecked(), radiogroup_gender.getTextButtonChecked(), 1)
            }else{
                if(chipgroup_status.getTextChipChecked().isNotEmpty()){
                    viewModel.getByStatus(chipgroup_status.getTextChipChecked(), 1)
                }else{
                    viewModel.getByGender(radiogroup_gender.getTextButtonChecked(), 1)
                }
            }

            val filter = arrayOf(chipgroup_status.checkedChipId, radiogroup_gender.checkedRadioButtonId)
            val num = filter[0]
            val num2 = filter[1]
            Log.d("Filter", num.toString() + " "+ num2.toString())
            Log.d("FilterSize", filter.size.toString())

            if(filter.isNotEmpty()) {
                viewModel.filterValue.value = filter
            }

            findNavController().popBackStack(R.id.listFragment, false)
        }
    }
}