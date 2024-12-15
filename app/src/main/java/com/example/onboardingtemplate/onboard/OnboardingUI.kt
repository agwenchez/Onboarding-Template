package com.example.onboardingtemplate.onboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OnboardingUi(onboardingModel: OnboardingModel){
    Column(modifier = Modifier.fillMaxSize(),   verticalArrangement = Arrangement.Center, // Centers content vertically
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(
            modifier = Modifier.size(90.dp)
        )
            Image(
                painter = painterResource(id = onboardingModel.image),
                contentDescription = null,
                modifier = Modifier
                    .padding(20.dp, 0.dp),
                alignment = Alignment.Center
            )
        Spacer(
            modifier = Modifier.size(70.dp)
        )
        Text(
            text = onboardingModel.title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 0.dp),
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black
        )
        Spacer(
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = onboardingModel.description,
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp, 0.dp),
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Black,
            fontWeight = FontWeight.Normal
        )
    }
}


@Preview(showBackground = true)
@Composable
fun OnboardingUIPreview1(){
    OnboardingUi(OnboardingModel.FirstPage)
}