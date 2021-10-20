package com.example.ifsomnauts.repository

import com.example.ifsomnauts.models.Character
import com.example.ifsomnauts.models.Characteristic
import com.example.ifsomnauts.models.Skill

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

        return char;
    }
}