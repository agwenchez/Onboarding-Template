package com.example.onboardingtemplate.ui.screens

import com.example.onboardingtemplate.KwanguKwakoApplication
import com.example.onboardingtemplate.data.ProductRepository
import com.example.onboardingtemplate.model.ProductDetails


/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch
import okio.IOException
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY

sealed interface ProductsUiState{
    data class Success(val products: List<ProductDetails>) : ProductsUiState
    object Error : ProductsUiState
    object Loading : ProductsUiState
}

class ProductsViewModel(private val productsRepository: ProductRepository) : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var productsUiState: ProductsUiState by mutableStateOf(ProductsUiState.Loading)
        private set

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getProducts()
    }

    /**
     * Gets Products information from the Mars API Retrofit service and updates the
     * [ProductsDetails] [List] [MutableList].
     */
    fun getProducts() {
        viewModelScope.launch{
            productsUiState = try {
                ProductsUiState.Success(productsRepository.getProducts())
            }catch (e: IOException){
                ProductsUiState.Error
            }

        }
    }

    companion object{
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as KwanguKwakoApplication)
                val productsRepository = application.container.productRepository
                ProductsViewModel(productsRepository = productsRepository)
            }
        }
    }
}
