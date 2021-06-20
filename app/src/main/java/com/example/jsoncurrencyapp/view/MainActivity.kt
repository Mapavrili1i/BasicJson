package com.example.jsoncurrencyapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jsoncurrencyapp.R
import com.example.jsoncurrencyapp.model.Test3.CaseStudy
import com.example.jsoncurrencyapp.model.Test1.CryptoModel
import com.example.jsoncurrencyapp.model.Test1.Test2.DenemeModeliItem
import com.example.jsoncurrencyapp.service.Test3.JsonApi
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
    private var caseStudies: ArrayList<CaseStudy>? = null

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

   //     TEST 1-2
  //      val service = retrofit.create(CryptoAPI::class.java)
  //      val call = service.getData2()
//
  //      call.enqueue(object :Callback<List<DenemeModeliItem>>{
  //          override fun onResponse(
  //              call: Call<List<DenemeModeliItem>>,
  //              response: Response<List<DenemeModeliItem>>
  //          ) {
  //              if (response.isSuccessful){
  //                  response.body().let {
  //                      denemeModeli= ArrayList(it)
  //                      for (deneme:DenemeModeliItem in denemeModeli!!)
  //                      {
  //                          print(deneme.currency+" : ")
  //                          println(deneme.price)
  //                          println("*****************")
  //                      }
  //                  }
  //              }
  //          }
  //          override fun onFailure(call: Call<List<DenemeModeliItem>>, t: Throwable) {
  //              t.printStackTrace()
  //          }
  //      })

  //     TEST 3
        val service2 = retrofit.create(JsonApi::class.java)
        val call2 = service2.getData3()

        call2.enqueue(object :Callback<List<CaseStudy>>{
            override fun onResponse(
                call: Call<List<CaseStudy>>,
                response: Response<List<CaseStudy>>
            ) {
                if (response.isSuccessful){
                    response.body().let {
                        caseStudies=ArrayList(it)
                        for (case: CaseStudy in caseStudies!!){
                            println(case.id)
                            println(case.title)
                            println(case.app_store_url)

                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<CaseStudy>>, t: Throwable) {
                t.printStackTrace()
            }

        })

    }
}