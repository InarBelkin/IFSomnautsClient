package com.example.ifsomnauts.ui.world_story.map_ws

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ifsomnauts.R

class MapWsFragment : Fragment() {

    companion object {
        fun newInstance() = MapWsFragment()
    }

    private lateinit var viewModel: MapWsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MapWsViewModel::class.java)

        return inflater.inflate(R.layout.map_ws_fragment, container, false)
    }



}