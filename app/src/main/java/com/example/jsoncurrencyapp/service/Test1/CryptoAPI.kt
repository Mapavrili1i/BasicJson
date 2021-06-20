package com.example.jsoncurrencyapp.service.Test1

import com.example.jsoncurrencyapp.model.Test3.CaseStudy
import retrofit2.Call
import retrofit2.http.GET


interface CryptoAPI {
    //https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json

   // @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
   @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
   // fun getData1() : Call<List<CryptoModel>>
   // fun getData2() : Call<List<DenemeModeliItem>>
   fun getData3() : Call<List<CaseStudy>>

}