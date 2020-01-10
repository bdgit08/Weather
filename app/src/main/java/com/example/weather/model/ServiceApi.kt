package com.example.weather.model

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface ServiceApi {

    @GET("forecast")
    fun callForecast(@Query("zip") zip: String, @Query("APPID") apikey : String , @Query("q") loc:String , @Query("units") unit:String):Call<Example>

    companion object{
        private var api : ServiceApi ?= null
        fun create() : ServiceApi{
            if (api == null){
                val httpClient = OkHttpClient.Builder()
                    .connectTimeout(30,TimeUnit.SECONDS)
                    .readTimeout(30,TimeUnit.SECONDS)
                    .writeTimeout(30,TimeUnit.SECONDS)
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.openweathermap.org/data/2.5/")
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
                    .client(httpClient.build())
                    .build()
                api = retrofit.create(ServiceApi::class.java)
            }
            return api!!
        }
    }
}