package com.example.growgh

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.*
import org.json.JSONException
import org.json.JSONObject

class FeedPage() : AppCompatActivity(){

    private lateinit var imageAdapter : ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_page)

        //initialising adapter
        Log.i("anshi","enteredA")
        val recyclerView : RecyclerView = findViewById(R.id.Rview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        imageAdapter = ImageAdapter()
        recyclerView.adapter = imageAdapter

     //instantiate the response queue
        val url = "https://pixabay.com/api/?key=38179195-94553b238874bd944eabced50&q=yellow+flowers&image_type=photo"

        val JsonRequest = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                Log.i("anshi","entered")
                val jsonArray = response?.getJSONArray("hits")
                val imagesArray = ArrayList<String>()
                for(i in 0 until jsonArray!!.length()){
                    val jsonImageObject = jsonArray.getJSONObject(i)
                    val image = jsonImageObject.getString("largeImageURL")

                    imagesArray.add(image)
                }
                Log.d("anshi", imagesArray.size.toString())
                imageAdapter.updateImages(imagesArray)
            },
            { Toast.makeText(this,"That didn't work!",Toast.LENGTH_LONG).show() })
        MySingleton.getInstance(this).addToRequestQueue(JsonRequest)
        Log.i("anshi","exited")
}}



