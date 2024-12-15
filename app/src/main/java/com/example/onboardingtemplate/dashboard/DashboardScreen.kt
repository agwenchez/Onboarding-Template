package com.example.onboardingtemplate.dashboard

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onboardingtemplate.R


data class BottomNavigationItem(
    val title : String,
    val selectedIcon : ImageVector,
    val unselectedIcon : ImageVector,
    val hasNews : Boolean,
    val badgeCount : Int? = null
)

@Composable
fun Dashboard() {
    val items = listOf(
        BottomNavigationItem(
            "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false,
            badgeCount = null
        ),
        BottomNavigationItem(
            "Chat",
            selectedIcon = Icons.Filled.Email,
            unselectedIcon = Icons.Outlined.Email,
            hasNews = false,
            badgeCount = 45
        ),
        BottomNavigationItem(
            "Settings",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            hasNews = true,
            badgeCount = null
        ),
    )

    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar(
                    containerColor = Color.White,
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp) // Custom top-left and top-right corner radius
                        )
//          
                ) {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            modifier = Modifier.background(Color.White),
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
                            },
                            label = { Text(text = item.title) },
//                            alwaysShowLabel = false,
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color(android.graphics.Color.parseColor("#00A36C")), // Custom selected icon color
                                unselectedIconColor = Color.Black, // Custom unselected icon color
                                selectedTextColor = Color(android.graphics.Color.parseColor("#00A36C")), // Custom selected text color
                                unselectedTextColor = Color.Gray // Custom unselected text color
                            ),
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (item.badgeCount != null) {
                                            Badge { Text(text = item.badgeCount.toString()) }
                                        } else if (item.hasNews) {
                                            Badge()
                                        }
                                    },
//                                    modifier = Modifier.background(Color.White)
                                ) {
                                    Icon(
                                        imageVector = if (index == selectedItemIndex)
                                            item.selectedIcon else item.unselectedIcon,
                                        contentDescription = item.title
                                    )
                                }
                            }
                        )
                    }
                }
            }
        )
        { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                when (selectedItemIndex) {
                    0 -> HomeContent()
                    1 -> SearchContent()
                    2 -> SettingsContent()
                    else -> Text("Select a tab",)
                }
            }
        }
    }
}

@Composable
fun HomeContent(modifier: Modifier = Modifier) {
    var searchInput by remember {  mutableStateOf("")}
    // Content for Home tab
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
            placeholder = { Text( text = "Enter your password") },
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
                    Spacer(modifier = Modifier.size(12.dp))
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

                    Spacer(modifier = Modifier.size(18.dp))
                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(8.dp),
//                        modifier = Modifier.clip(RoundedCornerShape(3.dp))
                    ){
                        Text("Explore our cooks")
                    }
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
        items(10) {
            ListColumnItemView() // LazyColumn items below LazyRow
        }
    }
}

@Composable
fun ScrollableListRow() {
    // List of DummyData items

    val items = listOf(
        DummyData.FirstItem,
        DummyData.SecondItem,
        DummyData.ThirdItem
    )
    LazyRow (
        modifier = Modifier.fillMaxSize().padding(top = 8.dp),
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
                .height(80.dp)
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
fun ScrollableListColumn() {
    // List of DummyData items

    val items = listOf(
        DummyData.FirstItem,
        DummyData.SecondItem,
        DummyData.ThirdItem
    )
    LazyColumn (
//        modifier = Modifier.fillMaxSize().padding(8.dp).background(Color.Gray),
//        state = rememberLazyListState()
    ) {
        // Properly passing the items list and handling each item
        items(10) { item ->
            ListColumnItemView()
        }
    }
}


@Composable
fun ListColumnItemView() {
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
                modifier = Modifier.size(100.dp).clip(RoundedCornerShape(8.dp))
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
                        contentDescription = "Ratomg",
                        tint = Color(android.graphics.Color.parseColor("#FCD400")),
                        modifier = Modifier.size(16.dp)
                    )
                    Text(text = "4.7")
                }
            }

            Button(
                onClick = {},
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.align(Alignment.Bottom).padding(start = 12.dp)
            ){
                Text(text = "Buy")
            }
            
        }
    }
}


@Composable
fun SearchContent(modifier: Modifier = Modifier) {
    // Content for Search tab
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
            Text(text = "Welcome to Search Screen!", modifier = Modifier)
        }
    }
}

@Composable
fun SettingsContent(modifier: Modifier = Modifier) {
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
            Text(text = "Welcome to Settings Screen!", modifier = Modifier)
        }
    }
}


@Composable
fun SearchInputField(
    modifier: Modifier = Modifier,
    value: String,
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int? = null,
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
            // Only add the leadingIcon if it's not null
            leadingIcon?.let {
                Icon(painter = painterResource(id = it), contentDescription = null)
            }
        },
        placeholder = placeholder,
        keyboardOptions = keyboardOptions,
        modifier = modifier,
//            shape = RoundedCornerShape(32.dp)
    )
}
@Preview
@Composable
fun DashboardPreview(){
    Dashboard()
}