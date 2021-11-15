package com.example.ifsomnauts.repository.connection
import com.example.ifsomnauts.models.account.IsAuthDto
import com.example.ifsomnauts.models.account.registerAnswer
import com.example.ifsomnauts.models.account.userDto
import retrofit2.Call
import com.example.ifsomnauts.models.account.userLogin
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AccountApi {
//    @POST("/account/login")
//    fun login(@Body userLogin: userLogin ): Call<registerAnswer>
//
//    @POST("/account/isAuth")
//    fun isAuth(@Header("Cookie") aspCookie:String) : Call<IsAuthDto>
    @GET("/api/account")
    fun sendToken(@Header("Authorization") bearer:String):Call<Void>
}