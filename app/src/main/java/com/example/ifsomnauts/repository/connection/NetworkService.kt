package com.example.ifsomnauts.repository.connection

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService {
    companion object {
        private var instance: NetworkService? = null;
        private const val Base_URL = "http://10.0.2.2:5000"
        private var mRetrofit: Retrofit? = null;
        val Instance: NetworkService
            get() {
                if (instance == null) {
                    instance = NetworkService();
                }
                return instance!!;
            }
    }

    init {
        mRetrofit = Retrofit.Builder().baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create()).build();
    }

    val hero:HeroApi = mRetrofit!!.create(HeroApi::class.java)
    val account:AccountApi = mRetrofit!!.create(AccountApi::class.java)





}