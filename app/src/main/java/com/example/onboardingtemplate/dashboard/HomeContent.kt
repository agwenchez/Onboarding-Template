package com.example.onboardingtemplate.dashboard

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.onboardingtemplate.R
import com.example.onboardingtemplate.ui.screens.ProductsUiState
import com.example.onboardingtemplate.ui.screens.ProductsViewModel

@Composable
fun HomeContent(
//    productsUiState: ProductsUiState,
//    retryAction: () -> Unit,
    modifier: Modifier = Modifier) {
    var searchInput by remember {  mutableStateOf("")}
    // Content for Home tab
//    when (productsUiState) {
////        is ProductsUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
//        is ProductsUiState.Success -> {
//            Log.d("Products", productsUiState.products.toString())
//
//        }
////            AmphibianDetailsScreen(
////            ProductsUiState.amphibians,
////            modifier = modifier
////                .padding(2.dp)
////                .fillMaxWidth()
////                .fillMaxHeight()
//////                .aspectRatio(1.5f)
////        )
////        is ProductsUiState.Error -> ErrorScreen(retryAction, modifier = modifier.fillMaxSize())
//        ProductsUiState.Error -> TODO()
//        ProductsUiState.Loading -> TODO()
//    }
    Column(
        modifier
            .padding(16.dp)
            .fillMaxSize()
//            .wrapContentSize(Alignment.Center)
        ,
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
    ) {
        SearchInputField(
            label = R.string.search_label,
//                    leadingIcon = R.drawable.percent,
            value = searchInput,
            onValueChange = { searchInput = it},
            modifier = Modifier
                .padding(bottom = 24.dp)
                .fillMaxWidth(),
            placeholder = { Text( text = "Search food or chef") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF0A330D), // hsla(150, 100%, 13%, 1) -> Dark green
                            Color(0xFFE1FDEB)  // hsla(150, 100%, 93%, 1) -> Light green
                        )
                    )
                )
                .padding(20.dp)
        ) {
            Row(modifier = Modifier) {
                Column(modifier = Modifier.weight(1.75f)){
                    Text(
                        "Ordering is Easy!",
                        fontSize = 30.sp,
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(modifier = Modifier.size(20.dp))
                    Text(
                        "Home cooked meals,",
                        fontSize = 15.sp,
//               modifier = Modifier.padding(bottom = 10.dp),
                        color = Color.White,
                        fontWeight = FontWeight.Light
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(
                        "Delivered to your doorstep",
                        fontSize = 15.sp,
//               modifier = Modifier.padding(bottom = 10.dp),
                        color = Color.White,
                        fontWeight = FontWeight.Light
                    )

//                    Spacer(modifier = Modifier.size(18.dp))
//                    Button(
//                        onClick = {},
//                        shape = RoundedCornerShape(8.dp),
////                        modifier = Modifier.clip(RoundedCornerShape(3.dp))
//                    ){
//                        Text("Explore our cooks")
//                    }
                }

                Column(modifier = Modifier.weight(1f)){
                    Box(
                        modifier = Modifier
//                            .size(500.dp)
                            .background(Color.Transparent) // Ensuring the background is transparent
                    ) {
                        Image(
                            painter = painterResource(R.drawable.pizza_maker),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
//                    Image(
//                        painter = painterResource(R.drawable.pizza_maker__1_),
//                        contentDescription = null,
//                        modifier = Modifier.size(500.dp)
//                    )
                }
            }

        }
//        ScrollableListRow()
//        ScrollableListColumn()
        CombinedScrollableLists()
    }
}


@Composable
fun SearchInputField(
    modifier: Modifier = Modifier,
    value: String,
    @StringRes label: Int,
    onValueChange: (String) -> Unit,
//        placeholder: @Composable () -> Unit,
    placeholder: @Composable () -> Unit,
    keyboardOptions: KeyboardOptions
){
    OutlinedTextField(
        value,
        onValueChange,
        singleLine = true,
        label = { Text(stringResource(label)) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "Search Icon",
                tint = MaterialTheme.colorScheme.onSurface // Use a visible color
            )
        },
        placeholder = placeholder,
        keyboardOptions = keyboardOptions,
        modifier = modifier,
    )
}

@Composable
fun CombinedScrollableLists() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
//            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        item {
            ScrollableListRow() // LazyRow inside the LazyColumn
        }

        item{
            HeaderUi(
                title = "Featured Items",
                subTitle = "Check out the latest!",
                textStyle = MaterialTheme.typography.titleLarge,
                fontSize = 18,
                subtitleTextStyle = MaterialTheme.typography.bodySmall,
                subTitleFontSize = 14
            )
        }
        items(10) {
            ListColumnItemView() // LazyColumn items below LazyRow
        }
    }
}

@Composable
fun ScrollableListRow() {
    HeaderUi(
        title = "Featured Items",
        subTitle = "Check out the latest!",
        textStyle = MaterialTheme.typography.titleLarge,
        fontSize = 14,
        subtitleTextStyle = MaterialTheme.typography.bodySmall,
        subTitleFontSize = 11
    )
    LazyRow (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp),
//        state = rememberLazyListState()
    ) {
        // Properly passing the items list and handling each item
        items(10) { item ->
            ListRowItemView()
        }
    }
}

@Composable
fun ListRowItemView() {
    Surface(
        modifier = Modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(10.dp)),
//            .border(2.dp, Color.Gray),
        shadowElevation = 3.dp,
        tonalElevation = 8.dp,
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
//            .border(2.dp, Color.Gray)
                .clip(RoundedCornerShape(10.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Display the image from the drawable resource
            Image(
                painter = painterResource(R.drawable.image3),
                contentDescription = "food",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .clip(RoundedCornerShape(10.dp)),
            )
            Column(modifier = Modifier.padding(vertical = 5.dp)){
                Text(text = "Shawarma", fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 2.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = "Location",
                        tint = Color(android.graphics.Color.parseColor("#009944")),
                        modifier = Modifier.size(14.dp)
                    )
//            Text(text = "Kwa mama Oliech kanyo kanyo", color = Color(android.graphics.Color.parseColor("#6B7280")), fontSize = 12.sp)
                    // Handling the overflow logic
                    val locationText = "Kwa mama Oliech kanyo kanyo"
                    Column {
                        locationText.chunked(16).forEach { chunk ->
                            Text(
                                text = chunk,
                                color = Color(android.graphics.Color.parseColor("#6B7280")),
                                fontSize = 10.sp,
                                modifier = Modifier.padding(end = 8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun ListColumnItemView(
    buttonText : String = "Buy"
) {
    Surface(
        modifier = Modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(10.dp)),
//            .border(2.dp, Color.Gray),
        shadowElevation = 3.dp,
        tonalElevation = 8.dp,
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            //        horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Display the image from the drawable resource
            Image(
                painter = painterResource(R.drawable.burger),
                contentDescription = "food",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Column(modifier = Modifier.padding(start = 8.dp, top = 2.dp)) {
                Text(
                    text = "Shawarma",
                    modifier = Modifier.padding(bottom = 4.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold)
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = "Location",
                        tint = Color(android.graphics.Color.parseColor("#009944")),
                        modifier = Modifier.size(16.dp)
                    )
                    Text(text = "Kwa mama Oliech", modifier = Modifier.padding(bottom = 2.dp))
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Rating",
                        tint = Color(android.graphics.Color.parseColor("#FCD400")),
                        modifier = Modifier.size(16.dp)
                    )
                    Text(text = "4.7")
                }
            }

            Button(
                onClick = {},
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .padding(start = 12.dp)
            ){
                Text(text = buttonText)
            }

        }
    }
}


@Preview
@Composable
fun HomeContentPreview(){
    val productsViewModel: ProductsViewModel = viewModel(factory = ProductsViewModel.Factory)
    HomeContent(
//        productsUiState =  productsViewModel.productsUiState,
//        retryAction = productsViewModel::getProducts
    )
}