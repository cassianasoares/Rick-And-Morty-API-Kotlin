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
import com.demo.android.cassiana.rickandmortycardapp.ui.fragment.SharedViewModel
import com.demo.android.cassiana.rickandmortycardapp.ui.fragment.SharedViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_filter.*


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

        btn_make_filter.setOnClickListener {
            Log.d("TypeFilter", chipgroup_status.getTextChipChecked())
            if(chipgroup_status.getTextChipChecked().isNotEmpty() && radiogroup_gender.getTextButtonChecked().isNotEmpty()) {
                viewModel.getByStatusAndGender(chipgroup_status.getTextChipChecked(), radiogroup_gender.getTextButtonChecked(), 1)
            }else{
                if(chipgroup_status.getTextChipChecked().isNotEmpty()){
                    viewModel.getByStatus(chipgroup_status.getTextChipChecked(), 1)
                }else{
                    viewModel.getByGender(radiogroup_gender.getTextButtonChecked(), 1)
                }
            }

            findNavController().navigate(R.id.action_filterFragment_to_listFragment)
        }
    }
}