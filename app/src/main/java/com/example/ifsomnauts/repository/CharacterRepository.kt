package com.example.ifsomnauts.repository

import com.example.ifsomnauts.models.Character
import com.example.ifsomnauts.models.Characteristic
import com.example.ifsomnauts.models.Skill

class CharacterRepository {

    public fun getCharacter(): Character {
        val sk1 = Skill(); sk1.count = 12;

        val char = Character();
        char.skills = ArrayList(listOf<Skill>(sk1, Skill())) ;
        char.characteristics = ArrayList( listOf<Characteristic>(
            Characteristic(),
            Characteristic()
        ) );

        return char;
    }
}