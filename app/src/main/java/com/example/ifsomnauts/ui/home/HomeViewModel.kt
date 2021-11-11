package com.example.ifsomnauts.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ifsomnauts.models.account.IsAuthDto
import com.example.ifsomnauts.models.account.registerAnswer
import com.example.ifsomnauts.models.account.userDto
import com.example.ifsomnauts.models.account.userLogin
import com.example.ifsomnauts.repository.AuthRepository
import com.example.ifsomnauts.repository.connection.NetworkService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import javax.inject.Inject
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

@HiltViewModel
class HomeViewModel @Inject constructor(repository: AuthRepository) : ViewModel() {
    var authRepository: AuthRepository = repository;

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    var cat: String = "def"

    public fun Login(){

        val login = userLogin();
        login.userName = "Kotander2"
        login.password = "Kotander25#"
        login.rememberMe = true;
        NetworkService.Instance.account.login(login).enqueue(object : Callback<registerAnswer>{
            override fun onResponse(
                call: Call<registerAnswer>,
                response: Response<registerAnswer>
            ) {
                var resp = response.body();
            }

            override fun onFailure(call: Call<registerAnswer>, t: Throwable) {

            }

        });


    }

    public fun IsAuth(){
        val cookie = NetworkService.Instance.aspCookie;
        NetworkService.Instance.account.isAuth(cookie).enqueue(object : Callback<IsAuthDto>{
            override fun onResponse(call: Call<IsAuthDto>, response: Response<IsAuthDto>) {
               var isAuth = response.body();
            }

            override fun onFailure(call: Call<IsAuthDto>, t: Throwable) {

            }


        })

    }






}

