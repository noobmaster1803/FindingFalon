package com.example.findingfalon2

import android.app.appsearch.SearchResult
import android.example.findingfalon2.Planet
import android.example.findingfalon2.SearchRequest
import android.example.findingfalon2.Vehicle
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("planets")
    fun getPlanets(): Call<List<Planet>>

    @GET("vehicles")
    fun getVehicles(): Call<List<Vehicle>>

    @POST("find")
    fun findFalcone(@Body searchRequest: SearchRequest): Call<SearchResult>
}
