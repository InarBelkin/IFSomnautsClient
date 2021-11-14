package com.example.ifsomnauts.repository

import androidx.lifecycle.MutableLiveData
import com.example.ifsomnauts.models.account.userDto
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject
import javax.inject.Singleton


class AuthRepository @Inject constructor() {
    companion object {
       var user = MutableLiveData<FirebaseUser?>(FirebaseAuth.getInstance().currentUser);
    }
}