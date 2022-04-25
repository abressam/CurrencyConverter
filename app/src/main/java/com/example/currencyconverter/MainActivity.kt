package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.currencyconverter.api.CurrencyConverterApi
import com.example.currencyconverter.remote.CurrencyConverterService
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getCurrencies()
    }

    fun getCurrencies() {
        val retrofitClient = CurrencyConverterService.getRetrofitInstance("https://cdn.jsdelivr.net/")
        val api = retrofitClient.create(CurrencyConverterApi::class.java)

        api.getCurrencies().enqueue(object : retrofit2.Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                var data = mutableListOf<String>()

                response.body()?.keySet()?.iterator()?.forEach {
                    data.add(it)
                }
                println(data.count())
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                println("Não foi executado.")
            }
        })
    }
}