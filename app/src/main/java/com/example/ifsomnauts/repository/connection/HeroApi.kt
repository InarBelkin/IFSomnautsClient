package com.example.ifsomnauts.repository.connection

import retrofit2.Call
import com.example.ifsomnauts.models.Hero
import retrofit2.http.GET

interface HeroApi {
    @GET("/api/hero")
    public fun getCurrentHero():Call<Hero>

}