package com.example.onboardingtemplate.data

import com.example.onboardingtemplate.network.ProductsApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val productRepository : ProductRepository
}

val json = Json {
    ignoreUnknownKeys = true // Ignore fields in JSON not present in your data class
}
class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://kwangu2kwako.com/api/v1/"
    // Retrofit instance with OkHttp client and JSON converter
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    // Retrofit Service
    private val retrofitService: ProductsApiService by lazy {
        retrofit.create(ProductsApiService::class.java)
    }
    // Amphibian Repository
    override val productRepository: ProductRepository by lazy {
        NetworkProductRepository(retrofitService)
    }
}