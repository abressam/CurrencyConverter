package com.example.currencyconverter.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CurrencyConverterService {
    companion object {
        fun getRetrofitInstance(path: String) : Retrofit {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}