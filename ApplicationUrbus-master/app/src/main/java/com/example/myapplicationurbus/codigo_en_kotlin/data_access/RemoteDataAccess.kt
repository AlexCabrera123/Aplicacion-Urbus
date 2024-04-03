package com.example.myapplicationurbus.codigo_en_kotlin.data_access

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataAccess {

    private val  retrofit =Retrofit.Builder()
        .baseUrl("https://maps.googleapis.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private var service = retrofit.create(Servicios::class.java)
    /**
    suspend fun getMedidass(
    units:String,
    origins: String, destination: String, key: String): Any? = withContext(Dispatchers.IO){
    service.getDistanceAndTime(units,origins,destination,key)

    }**/
    suspend fun getMedidas(
        units:String,
        origins: String, destination: String, key: String){
        service.getDistanceAndTime(units,origins,destination,key)

    }
}