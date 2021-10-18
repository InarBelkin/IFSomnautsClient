package com.example.ifsomnauts.ui.world_story.character_ws
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ifsomnauts.models.Character
import com.example.ifsomnauts.repository.CharacterRepository

class CharacterWsViewModel() : ViewModel() {
    var pers: MutableLiveData<Character> = MutableLiveData(CharacterRepository().getCharacter())

}