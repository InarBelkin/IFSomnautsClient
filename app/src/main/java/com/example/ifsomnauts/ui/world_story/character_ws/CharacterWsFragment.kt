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
import com.example.ifsomnauts.databinding.FragmentHomeBinding

class CharacterWsFragment : Fragment() {

//    private var _binding: CharacterWsFragmentBinding? = null;
//    private var binding get() = _binding!!


    private var _binding: CharacterWsFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: CharacterWsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.character_ws_fragment, container, false);
        viewModel = ViewModelProvider(requireActivity()).get(CharacterWsViewModel::class.java);
        binding.viewmodel = viewModel;




        return binding.root;
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }





}