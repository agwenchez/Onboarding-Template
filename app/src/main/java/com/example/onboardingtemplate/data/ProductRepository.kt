package com.example.onboardingtemplate.data

import com.example.onboardingtemplate.model.ProductDetails
import com.example.onboardingtemplate.network.ProductsApiService


interface ProductRepository {
    suspend fun getProducts() : List<ProductDetails>
}

class NetworkProductRepository(private val productsApiService: ProductsApiService) : ProductRepository{
    override suspend fun getProducts(): List<ProductDetails> = productsApiService.getProducts()
}