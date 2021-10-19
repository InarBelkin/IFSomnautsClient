package com.example.ifsomnauts.ui.world_story.map_ws

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ifsomnauts.repository.EncountersRepository

class MapWsViewModel : ViewModel() {
    var shortEncounters = MutableLiveData( EncountersRepository().getAllShortEncounters());
}