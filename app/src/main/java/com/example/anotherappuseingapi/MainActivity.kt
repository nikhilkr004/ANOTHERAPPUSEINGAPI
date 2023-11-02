package com.example.anotherappuseingapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {

    lateinit var  recyclerView: RecyclerView
    lateinit var adapterClass: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView= findViewById(R.id.recyclerview)


var retrofit =Retrofit.Builder()
    .baseUrl("https://dummyjson.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(APINTERFACE::class.java)

var retrofitData=retrofit.getUserData()

retrofitData.enqueue(object : Callback<Product?> {
    override fun onResponse(call: Call<Product?>, response: Response<Product?>) {

        var respnceBody =response.body()

        var  userData = respnceBody?.users!!

  adapterClass= Adapter(this@MainActivity, userData)


        recyclerView.adapter= adapterClass
        recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)

        Log.d("nikhil", "Data are  create "+ response.message())



    }

    override fun onFailure(call: Call<Product?>, t: Throwable) {
     Log.d("nikhil", "something error"+ t.message)
    }
})
    }
}