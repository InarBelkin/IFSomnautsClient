package com.example.ifsomnauts.ui.world_story.encounter_ws

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ifsomnauts.R
import com.example.ifsomnauts.additional.AnswerRecyclerAdapter
import com.example.ifsomnauts.additional.ReplicaAdapter
import com.example.ifsomnauts.databinding.EncounterWsFragmentBinding

class EncounterWsFragment : Fragment() {


    private lateinit var viewModel: EncounterWsViewModel
    private var _binding: EncounterWsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.encounter_ws_fragment, container, false);
        viewModel = ViewModelProvider(requireActivity()).get(EncounterWsViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner;
        binding.replicasRecycler.layoutManager = object :
            LinearLayoutManager(requireContext()) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        binding.replicasRecycler.adapter = ReplicaAdapter(viewModel.currentReplicas.value!!);
        binding.answersRecycler.layoutManager = object :
            LinearLayoutManager(requireContext()) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        binding.answersRecycler.adapter = AnswerRecyclerAdapter(viewModel.currentAnswers.value!!)

        binding.encounterScroll.post { binding.encounterScroll.fullScroll(View.FOCUS_DOWN) }

        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}