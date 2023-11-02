package com.example.anotherappuseingapi

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

interface  APINTERFACE {
@GET ("users")

fun getUserData():retrofit2.Call<Product>

}