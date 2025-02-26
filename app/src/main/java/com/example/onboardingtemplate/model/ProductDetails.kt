package com.example.onboardingtemplate.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductDetails(
    @SerialName("id")
    val id: String,

    @SerialName("createdAt")
    val createdAt: String,

    @SerialName("updatedAt")
    val updatedAt: String,

    @SerialName("name")
    val name: String,

    @SerialName("description")
    val description: String,

    @SerialName("deliveryTime")
    val deliveryTime: String,

    @SerialName("category")
    val type: String, // Mapping "category" → "type"

    @SerialName("image")
    val imgSrc: String, // Mapping "image" → "imgSrc"

    @SerialName("merchantId")
    val merchantId: String,

    @SerialName("orderId")
    val orderId: String?, // Nullable because it's null in your example

    @SerialName("prices")
    val priceList: List<Price> // Mapping "prices" → "priceList"
)

@Serializable
data class Price(
    @SerialName("id")
    val id: String,

    @SerialName("createdAt")
    val createdAt: String,

    @SerialName("updatedAt")
    val updatedAt: String,

    @SerialName("value")
    val amount: String, // Mapping "value" → "amount"

    @SerialName("unit")
    val unit: String,

    @SerialName("productId")
    val productId: String
)
