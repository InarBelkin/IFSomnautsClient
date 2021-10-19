package com.example.ifsomnauts.ui.world_story

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ifsomnauts.ui.world_story.character_ws.CharacterWsFragment
import com.example.ifsomnauts.ui.world_story.encounter_ws.EncounterWsFragment
import com.example.ifsomnauts.ui.world_story.map_ws.MapWsFragment

class FragmentWsAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    val changeCallback: (Int) -> Unit
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 3;
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> {
                val mf = MapWsFragment();
                mf.changeCallback = changeCallback;
                return mf;
            }
            2 -> EncounterWsFragment()
            else -> CharacterWsFragment()
        }
    }


}