package com.example.ifsomnauts.ui.world_story.map_ws

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ifsomnauts.R
import com.example.ifsomnauts.additional.ShortEncounterRecyclerAdapter
import com.example.ifsomnauts.databinding.MapWsFragmentBinding

class MapWsFragment : Fragment() {

    public lateinit var changeCallback: (Int)->Unit;

   private var _binding: MapWsFragmentBinding? = null;

    private val binding get()= _binding!!

    private lateinit var viewModel: MapWsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.map_ws_fragment, container, false);

        viewModel = ViewModelProvider(requireActivity()).get(MapWsViewModel::class.java);
        binding.viewmodel = viewModel;

        binding.shortEncountersRecycler.layoutManager = object :
            LinearLayoutManager(requireContext()) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }

        binding.shortEncountersRecycler.adapter =
            ShortEncounterRecyclerAdapter(viewModel.shortEncounters.value!!, changeCallback);

        return binding.root;
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}