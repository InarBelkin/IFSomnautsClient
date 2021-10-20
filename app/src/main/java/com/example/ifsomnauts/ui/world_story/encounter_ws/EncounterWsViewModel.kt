package com.example.ifsomnauts.ui.world_story.encounter_ws

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ifsomnauts.repository.EncountersRepository

class EncounterWsViewModel : ViewModel() {
    var currentReplicas = MutableLiveData(EncountersRepository().getEncounterLastReplicas("0"));

}