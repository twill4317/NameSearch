package com.godaddy.namesearch

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface NameSearchServices {

    @GET("/search/exact")
    fun performSearch(@Path("query") query: String?): Call<List<Domain>>
    @GET("/user/payment-methods")
    fun getPaymentMethods(): Call<List<PaymentMethod>>

    @POST("/payments/process")
    fun postPayments(): String
    @POST("/auth/login")
    fun postLogin(username: String, password: String)

    companion object NameSearchClient {

        private var nameSearchServices: NameSearchServices? = null

        @Synchronized
        fun getInstance() : NameSearchServices {

            if (nameSearchServices == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://gd.proxied.io")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                nameSearchServices = retrofit.create(NameSearchServices::class.java)
            }
            return nameSearchServices!!
        }
    }
}