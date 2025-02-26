package com.example.onboardingtemplate.ui

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.onboardingtemplate.dashboard.Dashboard
import com.example.onboardingtemplate.ui.screens.ProductsViewModel

@Composable
fun AmphibiansApp() {
//    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
//        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {  }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val productsViewModel: ProductsViewModel = viewModel(factory = ProductsViewModel.Factory)
            Log.d("padding", it.toString())
            Dashboard(
                productsUiState =  productsViewModel.productsUiState,
                retryAction = productsViewModel::getProducts,
//                modifier = Modifier.padding(it)
            )
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AmphibiansTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
//    CenterAlignedTopAppBar(
//        scrollBehavior = scrollBehavior,
//        title = {
//            Text(
//                text = stringResource(R.string.app_name),
//                style = MaterialTheme.typography.headlineSmall,
//            )
//        },
//        modifier = modifier
//    )
//}