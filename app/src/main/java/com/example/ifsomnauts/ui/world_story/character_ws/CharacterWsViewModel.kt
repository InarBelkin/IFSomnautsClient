package com.example.ifsomnauts.ui.world_story.character_ws

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ifsomnauts.models.Character
import com.example.ifsomnauts.models.Hero
import com.example.ifsomnauts.repository.CharacterRepository
import com.example.ifsomnauts.repository.connection.GsonRequest
import com.example.ifsomnauts.repository.connection.NetworkService
import com.example.ifsomnauts.repository.connection.RequestSingleton
import retrofit2.Call
import java.util.HashMap
import retrofit2.Callback
import retrofit2.Response


class CharacterWsViewModel() : ViewModel() {
    var character: MutableLiveData<Character> =
        MutableLiveData(CharacterRepository().getCharacter())


    init {
        //updCharacter();
        testChar();
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
            }, { })
        RequestSingleton.getInstance().addToRequestQueue(request);


    }

    fun testChar() {
        NetworkService.Instance.hero.getCurrentHero().enqueue(object : Callback<Hero>{
            override fun onResponse(call: Call<Hero>, response: Response<Hero>) {
                var hero = response.body();
            }
            override fun onFailure(call: Call<Hero>, t: Throwable) {

            }


        });

    }


}