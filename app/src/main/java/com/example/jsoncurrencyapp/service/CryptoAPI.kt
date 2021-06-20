package com.example.jsoncurrencyapp.service

import com.example.jsoncurrencyapp.model.CryptoModel
import com.example.jsoncurrencyapp.model.DenemeModeliItem
import retrofit2.Call
import retrofit2.http.GET


interface CryptoAPI {
    //https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json

   // @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
   @GET("users/{user}/repos")
    fun getData1() : Call<List<CryptoModel>>
    fun getData2() : Call<List<DenemeModeliItem>>

}