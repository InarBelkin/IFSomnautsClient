package com.example.ifsomnauts.ui.world_story

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.ifsomnauts.databinding.WorldStoryFragmentBinding
import com.google.android.material.tabs.TabLayout

class WorldStoryFragment : Fragment() {

    companion object {
        fun newInstance() = WorldStoryFragment()
    }

    private lateinit var viewModel: WorldStoryViewModel
    private var _binding: WorldStoryFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(WorldStoryViewModel::class.java)
        _binding = WorldStoryFragmentBinding.inflate(inflater, container, false);

        val fm = childFragmentManager;
        val adapter = FragmentWsAdapter(fm, lifecycle);
        binding.ViewPagerWs.isUserInputEnabled = false;
        binding.ViewPagerWs.adapter = adapter;

        binding.tabLayoutWs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    binding.ViewPagerWs.currentItem = tab.position
                };
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        binding.ViewPagerWs.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabLayoutWs.selectTab(binding.tabLayoutWs.getTabAt(position));
            }

        })
        return binding.root;
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}