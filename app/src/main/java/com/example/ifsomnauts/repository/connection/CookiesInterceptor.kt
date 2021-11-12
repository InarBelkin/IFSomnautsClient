package com.example.ifsomnauts.repository.connection

import com.example.ifsomnauts.repository.AuthRepository
import okhttp3.Interceptor
import okhttp3.Response

class CookiesInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalResponse = chain.proceed(chain.request());

        val aspCookie = originalResponse.header("Set-Cookie");

        if (aspCookie?.isNotEmpty() == true) {

            if (AuthRepository.authCookie.value != aspCookie)
                AuthRepository.authCookie.postValue(aspCookie);
        }
        return originalResponse;
    }
}