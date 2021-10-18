package com.example.ifsomnauts.ui.world_story.encounter_ws

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.ifsomnauts.R
import com.example.ifsomnauts.databinding.EncounterWsFragmentBinding

class EncounterWsFragment : Fragment() {

    companion object {
        fun newInstance() = EncounterWsFragment()
    }

    private lateinit var viewModel: EncounterWsViewModel
    private lateinit var binding:EncounterWsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.encounter_ws_fragment, container, false);




        return binding.root;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EncounterWsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}