package com.example.onboardingtemplate.onboard

import androidx.annotation.DrawableRes
import com.example.onboardingtemplate.R

sealed class OnboardingModel(
    @DrawableRes val image: Int,
    val title: String,
    val description: String,
) {

    data object FirstPage : OnboardingModel(
        image = R.drawable.barbecue,
        title = "All your Favourites",
        description = "Get all your sumptuous meals in one place. Just order and we will take care of the rest. We gachyu!"
    )

    data object SecondPage : OnboardingModel(
        image = R.drawable.chef,
        title = "Order from chosen Chef",
        description = "From a myriad of experienced chefs, choose from a point of abundance and enjoy your tailored meal"
    )

    data object ThirdPage : OnboardingModel(
        image = R.drawable.cart,
        title = "Daily Offers",
        description = "Every day features a new deal of the day from our pool of experienced chefs. Be sure to be on the look out"
    )
}