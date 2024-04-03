package com.example.myapplicationurbus.codigo_en_kotlin.data_access

import com.example.myapplicationurbus.codigo_en_kotlin.propiedades_distancia.InfoGeneral
import retrofit2.http.POST
import retrofit2.http.Query

//import com.example.myapplicationurbus.common_kotlin.propiedades_distancia.InfoGeneral

//import retrofit2.http.POST
//import retrofit2.http.Query

interface Servicios {
   @POST("maps/api/distancematrix/json?")
    suspend fun getDistanceAndTime(
       @Query("units") units: String,
       @Query("origins") origins: String,
       @Query ("destination") destination: String,
       @Query("Key") key: String
    ): InfoGeneral
}