package com.example.ifsomnauts.ui.world_story.character_ws

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.ifsomnauts.models.Character
import com.example.ifsomnauts.repository.CharacterRepository
import com.example.ifsomnauts.repository.connection.GsonRequest
import com.example.ifsomnauts.repository.connection.RequestSingleton
import org.json.JSONObject
import java.util.HashMap


class CharacterWsViewModel() : ViewModel() {
    //var pers: MutableLiveData<Character> = MutableLiveData(CharacterRepository().getCharacter())
    var pers: MutableLiveData<Character> = MutableLiveData(CharacterRepository().getCharacter())


    init {
        updCharacter();
    }

    fun updCharacter() {
        val url = RequestSingleton.url + "character";
        var character: Character = Character();
        val headers: MutableMap<String, String> = HashMap()
        headers["Content-Type"] = "application/json"
        val request = GsonRequest<Character>(
            url,
            Character::class.java,
            headers,
            { character ->
           var c = character;
                pers.value = character;
            }, {
                val a  = it;
            })

        RequestSingleton.getInstance().addToRequestQueue(request);
    }


}