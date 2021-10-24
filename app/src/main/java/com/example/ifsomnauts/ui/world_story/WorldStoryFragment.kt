package com.example.ifsomnauts.ui.world_story

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.widget.ViewPager2
import com.example.ifsomnauts.R
import com.example.ifsomnauts.databinding.WorldStoryFragmentBinding
import com.google.android.material.tabs.TabLayout

class WorldStoryFragment : Fragment() {

    private lateinit var viewModel: WorldStoryViewModel
    private var _binding: WorldStoryFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity()).get(WorldStoryViewModel::class.java)
        _binding = WorldStoryFragmentBinding.inflate(inflater, container, false);
        val host = childFragmentManager.findFragmentById(R.id.fragmentContainerView)as NavHostFragment;

//        val fm = childFragmentManager;
//        val adapter = FragmentWsAdapter(fm, lifecycle);
//        binding.ViewPagerWs.isUserInputEnabled = false;
//        binding.ViewPagerWs.adapter = adapter;

        binding.tabLayoutWs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    val actionString = when (tab.position) {
                        1 -> R.id.action_global_mapWsFragment
                        2 -> R.id.action_global_encounterWsFragment
                        else -> R.id.action_global_characterWsFragment2
                    }
                    host.navController
                        .navigate(actionString);

                };
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
        viewModel.changeCallback = { a -> this.setCurrentPage(a) }

//        binding.ViewPagerWs.registerOnPageChangeCallback(object :
//            ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                binding.tabLayoutWs.selectTab(binding.tabLayoutWs.getTabAt(position));
//            }
//
//        })




       host.navController
            .addOnDestinationChangedListener { navController, navDestination, bundle ->
                val position = when (navDestination.id) {
                    R.id.characterWsFragment2 -> 0;
                    R.id.mapWsFragment -> 1;
                    R.id.encounterWsFragment -> 2;
                    else -> 999;
                }
                binding.tabLayoutWs.selectTab(binding.tabLayoutWs.getTabAt(position));
            }


        return binding.root;
    }

    public fun setCurrentPage(number: Int) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}