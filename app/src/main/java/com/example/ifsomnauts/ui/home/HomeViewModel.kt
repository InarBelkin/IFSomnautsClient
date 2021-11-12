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

    var userName: String = "";
    var password: String = "";
    var message: MutableLiveData<String> = MutableLiveData("");

    public fun Login(){

        val login = userLogin();
        login.userName = userName;
        login.password = password;
        login.rememberMe = true;
        var answer:registerAnswer? = null;
        NetworkService.Instance.account.login(login).enqueue(object : Callback<registerAnswer>{
            override fun onResponse(
                call: Call<registerAnswer>,
                response: Response<registerAnswer>
            ) {
                answer = response.body();
                if(answer!=null){
                    message.value = answer!!.message;
                    if(answer!!.isSuccess){
                        val user = answer!!.user!!;
                        AuthRepository.user.value = user;
                    }
                }
                else message.value = "Не удалось залогиниться";
            }

            override fun onFailure(call: Call<registerAnswer>, t: Throwable) {
                message.value = "Ошибка соединения или что-то такое";
            }
        });



    }

    public fun IsAuth(){

        val cookie:String = AuthRepository.authCookie.value?:"";
        NetworkService.Instance.account.isAuth(cookie).enqueue(object : Callback<IsAuthDto>{
            override fun onResponse(call: Call<IsAuthDto>, response: Response<IsAuthDto>) {
               var isAuth = response.body();
            }

            override fun onFailure(call: Call<IsAuthDto>, t: Throwable) {

            }


        })

    }






}

