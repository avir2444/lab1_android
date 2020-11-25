package ro.ubbcluj.cs.ilazar.myapp2.todo.data.remote

import android.R.attr.start
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.gson.GsonBuilder
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.runBlocking
import okhttp3.*
import okhttp3.internal.ws.WebSocketProtocol
import okio.ByteString
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import retrofit2.http.Headers
import ro.ubbcluj.cs.ilazar.myapp2.core.Api
import ro.ubbcluj.cs.ilazar.myapp2.core.TAG
import ro.ubbcluj.cs.ilazar.myapp2.todo.data.Item


object ItemApi {
    interface Service {
        @GET("/api/jucator")
        suspend fun find(): List<Item>

        @GET("/api/jucator/{id}")
        suspend fun read(@Path("id") itemId: String): Item;

        @Headers("Content-Type: application/json")
        @POST("/api/jucator")
        suspend fun create(@Body item: Item): Item

        @Headers("Content-Type: application/json")
        @PUT("/api/jucator/{id}")
        suspend fun update(@Path("id") itemId: String, @Body item: Item): Item
    }

    val service: Service = Api.retrofit.create(Service::class.java)
}