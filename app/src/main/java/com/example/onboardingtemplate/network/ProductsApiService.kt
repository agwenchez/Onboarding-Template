package com.example.onboardingtemplate.network
import com.example.onboardingtemplate.model.ProductDetails
import retrofit2.http.GET

interface ProductsApiService {
    @GET("products")
    suspend fun getProducts() : List<ProductDetails>
}