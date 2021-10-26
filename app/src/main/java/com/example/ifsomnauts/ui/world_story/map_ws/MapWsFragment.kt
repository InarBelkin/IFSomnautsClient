package com.example.ifsomnauts.ui.world_story.map_ws

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ifsomnauts.MainActivity
import com.example.ifsomnauts.R
import com.example.ifsomnauts.additional.ShortEncounterRecyclerAdapter
import com.example.ifsomnauts.databinding.MapWsFragmentBinding
import com.example.ifsomnauts.ui.world_story.WorldStoryViewModel

class MapWsFragment : Fragment() {




    private var _binding: MapWsFragmentBinding? = null;

    private val binding get() = _binding!!

    private lateinit var viewModel: MapWsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.map_ws_fragment, container, false);

        viewModel = ViewModelProvider(requireActivity()).get(MapWsViewModel::class.java);
        val viewModelWS = ViewModelProvider(requireActivity()).get(WorldStoryViewModel::class.java)
        binding.viewmodel = viewModel;

        binding.shortEncountersRecycler.layoutManager = object :
            LinearLayoutManager(requireContext()) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }




        binding.shortEncountersRecycler.adapter =
            ShortEncounterRecyclerAdapter(viewModel.shortEncounters.value!!);

        return binding.root;
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}