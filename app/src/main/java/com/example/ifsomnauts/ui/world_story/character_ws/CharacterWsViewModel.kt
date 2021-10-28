package com.example.ifsomnauts.ui.world_story.character_ws

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ifsomnauts.models.Character
import com.example.ifsomnauts.repository.CharacterRepository
import com.example.ifsomnauts.repository.connection.GsonRequest
import com.example.ifsomnauts.repository.connection.RequestSingleton
import java.util.HashMap


class CharacterWsViewModel() : ViewModel() {
    var character: MutableLiveData<Character> =
        MutableLiveData(CharacterRepository().getCharacter())


    init {
        updCharacter();
    }

    fun updCharacter() {
        val url = RequestSingleton.url + "character";
        val headers: MutableMap<String, String> = HashMap()
        headers["Content-Type"] = "application/json"
        val request = GsonRequest<Character>(
            url,
            Character::class.java,
            headers,
            {
                this.character.value = it;
            }, {
                val a = it;
            })
        RequestSingleton.getInstance().addToRequestQueue(request);
    }


}