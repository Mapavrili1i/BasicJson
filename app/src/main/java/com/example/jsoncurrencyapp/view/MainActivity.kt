package com.example.jsoncurrencyapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jsoncurrencyapp.R
import com.example.jsoncurrencyapp.model.CryptoModel
import com.example.jsoncurrencyapp.model.DenemeModeli
import com.example.jsoncurrencyapp.model.DenemeModeliItem
import com.example.jsoncurrencyapp.service.CryptoAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json

class MainActivity : AppCompatActivity() {

    private val BASE_URL = "https://raw.githubusercontent.com/"
    private var cryptoModels: ArrayList<CryptoModel>? = null
    private var denemeModeli: ArrayList<DenemeModeliItem>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()
    }

    private fun loadData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

//        val service1 = retrofit.create(CryptoAPI::class.java)
//        val call1 = service1.getData1()
//
//        call1.enqueue(object : Callback<List<CryptoModel>>{
//            override fun onResponse(
//                call: Call<List<CryptoModel>>,
//                response: Response<List<CryptoModel>>
//            ) {
//                if (response.isSuccessful){
//                    response.body()?.let {
//                      cryptoModels= ArrayList(it)
//                      for (cryptoModel: CryptoModel in cryptoModels!!){
//                         // print(cryptoModel.currency+" : ")
//                         // println(cryptoModel.price)
//                      }
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {
//                t.printStackTrace()
//            }
//
//        })
//
        val service2 = retrofit.create(CryptoAPI::class.java)
        val call2 = service2.getData2()

        call2.enqueue(object :Callback<List<DenemeModeliItem>>{
            override fun onResponse(
                call: Call<List<DenemeModeliItem>>,
                response: Response<List<DenemeModeliItem>>
            ) {
                if (response.isSuccessful){
                    response.body().let {
                        denemeModeli= ArrayList(it)
                        for (deneme:DenemeModeliItem in denemeModeli!!){
                            print(deneme.currency+" : ")
                            println(deneme.price)
                            print("*****************")
                        }
                    }

                }

            }

            override fun onFailure(call: Call<List<DenemeModeliItem>>, t: Throwable) {
                t.printStackTrace()

            }


        })

    }
}