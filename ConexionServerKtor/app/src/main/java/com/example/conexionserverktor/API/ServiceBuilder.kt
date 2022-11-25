package com.example.conexionserverktor.API

object ServiceBuilder {
    val client = OkHttpClient.Builder().build()
    val url = "http://192.168.2.250:8080"
}