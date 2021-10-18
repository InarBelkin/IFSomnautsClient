package com.example.ifsomnauts.ui.world_story.character_ws

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.ifsomnauts.R
import com.example.ifsomnauts.databinding.CharacterWsFragmentBinding
import com.example.ifsomnauts.databinding.EncounterWsFragmentBinding

class CharacterWsFragment : Fragment() {

    private lateinit var binding: CharacterWsFragmentBinding;


    private lateinit var viewModel: CharacterWsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.character_ws_fragment, container, false);

        return binding.root;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CharacterWsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}