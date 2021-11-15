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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
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


    fun sendToken() {
        val user = FirebaseAuth.getInstance().currentUser;
        user?.getIdToken(false)?.addOnCompleteListener {
            if (it.isSuccessful) {
                val idToken = "Bearer " + it.result?.token
                NetworkService.Instance.account.sendToken(idToken).enqueue(object : Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        var code = response.code();
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        //TODO("Not yet implemented")
                    }
                });


            }
        }

    }


}

