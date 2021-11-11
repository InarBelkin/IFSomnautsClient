package com.example.ifsomnauts.repository.connection

import android.content.SharedPreferences
import android.preference.PreferenceManager
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.prefs.Preferences

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
        val okHttpClient = OkHttpClient().newBuilder();
        okHttpClient.interceptors().add(CookiesInterceptor());

        mRetrofit = Retrofit.Builder().baseUrl(Base_URL).client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create()).build();
    }

    val hero:HeroApi = mRetrofit!!.create(HeroApi::class.java)
    val account:AccountApi = mRetrofit!!.create(AccountApi::class.java)

    var aspCookie: String = ""

}