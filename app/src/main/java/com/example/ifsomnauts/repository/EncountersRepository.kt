package com.example.ifsomnauts.repository

import com.example.ifsomnauts.models.ShortEncounter

class EncountersRepository {
    public fun getAllShortEncounters(): ArrayList<ShortEncounter>{
        val enc1 = ShortEncounter("id001","Нападение волка")
        val enc2 = ShortEncounter("id032","Бродячий торговец")
        val enc3 = ShortEncounter("id964","Загадочный незнакомец")
        val encounters = ArrayList(listOf(enc1,enc2, enc3
            , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3
            , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 ));
        return encounters;
    }
}

