package com.example.conexionserverktor.API

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    val client = OkHttpClient.Builder().build()
    val url = "http://192.168.2.250:8080"
}