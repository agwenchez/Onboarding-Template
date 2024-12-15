package com.example.onboardingtemplate.dashboard

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.onboardingtemplate.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn

// Sealed class to hold the data
sealed class DummyData(
    @DrawableRes val image: Int,
    val title: String,
    val icon: ImageVector,
    val location: String
) {
    data object FirstItem : DummyData(
        image = R.drawable.burger,
        title = "Beef Burger",
        icon = Icons.Default.LocationOn,
        location = "Location 1"
    )

    data object SecondItem : DummyData(
        image = R.drawable.burger,
        title = "Beef Burger",
        icon = Icons.Default.LocationOn,
        location = "Location 2"
    )

    data object ThirdItem : DummyData(
        image = R.drawable.burger,
        title = "Kuku Kienyeji",
        icon = Icons.Default.LocationOn,
        location = "Location 3"
    )
}