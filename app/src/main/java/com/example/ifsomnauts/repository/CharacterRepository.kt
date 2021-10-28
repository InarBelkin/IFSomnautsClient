package com.example.ifsomnauts.repository

import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.ifsomnauts.models.Character
import com.example.ifsomnauts.models.Characteristic
import com.example.ifsomnauts.models.Skill
import com.example.ifsomnauts.repository.connection.RequestSingleton

class CharacterRepository {

    public fun getCharacter(): Character {
        val sk1 = Skill(); sk1.count = 12;
        sk1.name = "красноречие"

        val char = Character();
        char.skills = ArrayList(
            listOf<Skill>(
                sk1,
                Skill(),
                Skill(),
                Skill(),
                Skill(),
                Skill(),
                Skill(),
                Skill(),
                Skill(),
                Skill(),
                Skill(),
                Skill(),
               sk1,
                Skill(),
                Skill(),
                Skill(),
                Skill(),
                Skill(),
                Skill(),
                Skill(),
                Skill(),
                Skill(),
                Skill(),
                Skill(),
                Skill(),
                Skill(),
                Skill(),
                sk1

            )
        );
        val ch1 = Characteristic();
        ch1.name = "Опыт";
        ch1.count = 3F;
        ch1.countMax = 10F;
        char.characteristics = ArrayList(
            listOf<Characteristic>(
                ch1,
                Characteristic(),
                Characteristic(),
                Characteristic(),
                Characteristic(),
                Characteristic(),
                Characteristic(),
                Characteristic(),
                Characteristic(),
                Characteristic(),
                Characteristic(),
                Characteristic(),
                Characteristic(),
                Characteristic(),
                Characteristic(),
                Characteristic(),
                Characteristic(),
                Characteristic(),
                Characteristic(),
                Characteristic(),
            )
        );
        //getCharacterTest();
        return char;
    }

    fun getCharacterTest(){
        val url = RequestSingleton.url+"character";
        
        val request  = JsonObjectRequest(Request.Method.GET, url, null,
            {response->
                val r = response;
            },
            {error->})

        RequestSingleton.getInstance().addToRequestQueue(request);






    }


}