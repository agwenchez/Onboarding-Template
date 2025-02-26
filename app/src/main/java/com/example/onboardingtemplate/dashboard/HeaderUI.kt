package com.example.onboardingtemplate.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderUi(
    title : String = "Title",
    subTitle : String ?= "",
    textStyle: TextStyle = MaterialTheme.typography.titleMedium,
    fontSize: Int = 14,
    subtitleTextStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    subTitleFontSize: Int = 12,
){
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                fontSize = fontSize.sp,
                style = textStyle
            )
            if (!subTitle.isNullOrEmpty()) { // Conditionally display subtitle
                Text(
                    text = subTitle,
                    fontSize = subTitleFontSize.sp,
                    style = subtitleTextStyle
                )
            }
        }

        Button (
            onClick = {
            //coming soon
            },
            modifier = Modifier.weight(1f).width(50.dp),
            colors = ButtonDefaults.buttonColors(
//                contentColor = textColor,
                containerColor = Color.Transparent
            ),
            ) {
            Text( text = "See All")
            Icon(
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = "View All",
                tint = Color(android.graphics.Color.parseColor("#FCD400")),
                modifier = Modifier.size(16.dp)
            )
        }

    }
}