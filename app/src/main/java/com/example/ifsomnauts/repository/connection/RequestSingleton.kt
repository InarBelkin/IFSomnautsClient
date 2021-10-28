package com.example.ifsomnauts.repository.connection

import android.content.Context
import android.os.strictmode.InstanceCountViolation
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import java.lang.Exception

class RequestSingleton constructor(context: Context) {
    companion object {
        @Volatile
        private var INSTANCE: RequestSingleton? = null;
        fun firstGetInstance(context: Context) = INSTANCE ?: synchronized(this) {
            INSTANCE ?: RequestSingleton(context).also {
                INSTANCE = it
            }
        }
        fun getInstance() :RequestSingleton = INSTANCE?: throw Exception("Инстанс не инициализирован");
        val url = "http://10.0.2.2:5000/";
    }


    val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(context.applicationContext);
    }

    fun <T> addToRequestQueue(req: Request<T>) {
        requestQueue.add(req);
    }


}