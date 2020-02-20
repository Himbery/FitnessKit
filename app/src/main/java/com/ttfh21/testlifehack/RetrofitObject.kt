package com.ttfh21.testlifehack

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {

    val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://sample.fitnesskit-admin.ru/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}