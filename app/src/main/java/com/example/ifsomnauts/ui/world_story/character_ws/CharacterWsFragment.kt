package com.example.ifsomnauts.ui.world_story.character_ws

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ifsomnauts.R
import com.example.ifsomnauts.additional.CharacteristicRecyclerAdapter
import com.example.ifsomnauts.additional.SkillsRecyclerAdapter
import com.example.ifsomnauts.databinding.CharacterWsFragmentBinding

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
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.character_ws_fragment, container, false);
        viewModel = ViewModelProvider(requireActivity()).get(CharacterWsViewModel::class.java);
        binding.viewmodel = viewModel;
        binding.lifecycleOwner = viewLifecycleOwner;

        binding.CharacterisicsRecycler.layoutManager = object :
            LinearLayoutManager(requireContext()) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        binding.skillsRecycler.layoutManager = object :
            LinearLayoutManager(requireContext()) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        //TODO следить за изменением этих значений вьюмодели


        viewModel.character.observe(viewLifecycleOwner, {
            binding.CharacterisicsRecycler.adapter =
                CharacteristicRecyclerAdapter(viewModel.character.value?.characteristics!!);
            binding.skillsRecycler.adapter =
                SkillsRecyclerAdapter(viewModel.character.value?.skills!!);
        })
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}