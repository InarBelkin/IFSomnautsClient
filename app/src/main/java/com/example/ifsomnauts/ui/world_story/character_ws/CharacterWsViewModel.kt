package com.example.ifsomnauts.ui.world_story.character_ws

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ifsomnauts.models.Character
import com.example.ifsomnauts.models.Hero
import com.example.ifsomnauts.repository.CharacterRepository
import com.example.ifsomnauts.repository.connection.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CharacterWsViewModel() : ViewModel() {
    var character: MutableLiveData<Character> =
        MutableLiveData(CharacterRepository().getCharacter())


    init {
        //updCharacter();
        testChar();
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