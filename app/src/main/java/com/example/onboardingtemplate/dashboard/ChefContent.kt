package com.example.onboardingtemplate.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChefContent(modifier: Modifier = Modifier) {
    // Content for Settings tab
    Column(
        modifier
            .padding(16.dp)
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(onClick = {}){
            Text(text = "Welcome to Chefs Screen!", modifier = Modifier)
        }
    }
}

@Preview
@Composable
fun ChefContentPreview(){

}