package com.example.ifsomnauts.repository

import com.example.ifsomnauts.models.ShortEncounter
import com.example.ifsomnauts.models.dialog.Answer
import com.example.ifsomnauts.models.dialog.Replica

class EncountersRepository {
    public fun getAllShortEncounters(): ArrayList<ShortEncounter>{
        val enc1 = ShortEncounter("id001","Нападение волка")
        val enc2 = ShortEncounter("id032","Бродячий торговец")
        val enc3 = ShortEncounter("id964","Загадочный незнакомец")
        val encounters = ArrayList(listOf(enc1,enc2, enc3
            , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3
            , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3 , enc3, enc1 ));
        return encounters;
    }

    fun getEncounterLastReplicas(encounterId:String):ArrayList<Replica>{
        val replicas = ArrayList<Replica>(listOf(Replica("Встреча", "Вы видите седовласого старика с посохом, греющегося у костра." +
                "Он жестом приглашает вас присоединиться к нему"),
        Replica("Степан","Кто вы?"),
        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечает"),
//        Replica("Встреча","Старик ничего не отвечаетff"),
        ));
        return replicas;
    }

    fun  getCurrentAnswers():ArrayList<Answer>{
        var answers = ArrayList(listOf(Answer("Настойчиво повторить вопрос"),
        Answer("Ничего не делать"),
        Answer("[скрытность:5/4]Обчистить карманы")
        ));
        return  answers;
    }
}

