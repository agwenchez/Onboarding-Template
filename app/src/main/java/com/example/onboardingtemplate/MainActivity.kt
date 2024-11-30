package com.example.onboardingtemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.onboardingtemplate.onboard.OnboardingScreen
import com.example.onboardingtemplate.onboard.OnboardingUtils
import com.example.onboardingtemplate.ui.theme.OnboardingTemplateTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val onboardingUtils by lazy { OnboardingUtils(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            OnboardingTemplateTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    if (onboardingUtils.isOnboardingCompleted()) {
                        ShowHomeScreen()
                    } else {
                        ShowOnboardingScreen()
                    }
                }
            }
        }
    }

    @Composable
    private fun ShowHomeScreen() {
        Surface(modifier = Modifier.safeDrawingPadding().fillMaxSize(),) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Home Screen", style = MaterialTheme.typography.headlineLarge)
                Button(
                    onClick = {
                        onboardingUtils.setOnboardingStarted()
                        setContent{ ShowOnboardingScreen()}
                    }
                ) {
                    Text(text = "Back to Onboarding")
                }
            }
        }
    }

    @Composable
    private fun ShowOnboardingScreen() {
        val scope = rememberCoroutineScope()
        OnboardingScreen {
            onboardingUtils.setOnboardingCompleted()
            scope.launch {
                setContent {
                    ShowHomeScreen()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun OnboardingTemplatePreview() {
        OnboardingTemplateTheme {
            ShowHomeScreen()
        }
    }
}

