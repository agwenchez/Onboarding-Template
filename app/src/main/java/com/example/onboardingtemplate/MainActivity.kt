package com.example.onboardingtemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.onboardingtemplate.auth.SignInScreen
import com.example.onboardingtemplate.dashboard.Dashboard
import com.example.onboardingtemplate.onboard.OnboardingScreen
import com.example.onboardingtemplate.onboard.OnboardingUtils
import com.example.onboardingtemplate.ui.screens.ProductsViewModel
import com.example.onboardingtemplate.ui.theme.OnboardingTemplateTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val onboardingUtils by lazy { OnboardingUtils(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            OnboardingTemplateTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                  val productsViewModel: ProductsViewModel = viewModel(factory = ProductsViewModel.Factory)
                    if (onboardingUtils.isOnboardingCompleted()) {
                        SignInScreen {
                            onboardingUtils.setOnboardingStarted()
                            setContent {
                                Dashboard(
                                    productsUiState =  productsViewModel.productsUiState,
                                    retryAction = productsViewModel::getProducts
                                )
                            }
                        }
                    } else {
                        ShowOnboardingScreen()
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
    }

    @Composable
    private fun ShowOnboardingScreen() {
        val scope = rememberCoroutineScope()
        OnboardingScreen {
            onboardingUtils.setOnboardingCompleted()
            scope.launch {
                setContent {
                    val productsViewModel: ProductsViewModel = viewModel(factory = ProductsViewModel.Factory)
                    SignInScreen {
                        onboardingUtils.setOnboardingStarted()
                        setContent {
                            Dashboard(
                                productsUiState =  productsViewModel.productsUiState,
                                retryAction = productsViewModel::getProducts
                            )
                        }
                    }
                }
            }
        }
    }



    @Preview(showBackground = true)
    @Composable
    fun OnboardingTemplatePreview() {
        OnboardingTemplateTheme {
            SignInScreen {
                onboardingUtils.setOnboardingStarted()
                setContent {
                    ShowOnboardingScreen()
                }
            }
        }
    }
}

