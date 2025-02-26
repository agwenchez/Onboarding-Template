package com.example.onboardingtemplate.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileContent(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { TopBar("Profile") },
        content = { innerPadding ->
            MainContent(modifier = Modifier.padding(innerPadding))
        }
    )
//    Column(
//        modifier
//            .padding(16.dp)
//            .fillMaxSize()
//            .wrapContentSize(Alignment.Center)
//        ,
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ){
//        Button(onClick = {}){
//            Text(text = "Welcome to Profile Screen!", modifier = Modifier)
//        }
//    }
}
@Composable
fun MainContent(modifier: Modifier = Modifier) {
    Column{
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
            ,
    //            .border(1.dp, color = Color.Black),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Column 1: Image
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile Picture",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(60.dp)
                        .border(1.dp, color = Color.Black, shape = RoundedCornerShape(30.dp))
                        .padding(8.dp)
                )
            }

            // Column 2: Username, Phone, Email
            Column(
                modifier = Modifier.weight(2f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "John Doe",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "+123 456 7890",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
                Text(
                    text = "johndoe@example.com",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }

            // Column 3: Edit Icon
            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(30.dp)
                        .background(color = Color.LightGray, shape = RoundedCornerShape(20.dp))
                        .padding(6.dp)
                )
            }
        }

//        Spacer(modifier = Modifier.size(14.dp))
        Column(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.LightGray)) {  }
        Spacer(modifier = Modifier.size(16.dp))
        Column(modifier = Modifier
//            .fillMaxWidth()
//            .border(1.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
            .padding(16.dp)
        ) {
            Text(
                text="My Account",
                modifier = Modifier.padding(bottom = 12.dp),
//                style = MaterialTheme.typography.bodySmall,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Column(
                modifier = Modifier
//                    .fillMaxWidth()
//                    .border(1.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
                    .background(color = Color.LightGray, shape = RoundedCornerShape(16.dp))
                    .padding(14.dp)
            ) {

                RowItem(
                    icon = Icons.Default.LocationOn,
                    text = "Manage Address"
                )
                RowItem(
                    icon = Icons.Default.AccountBox,
                    text = "Payment"
                )
                RowItem(
                    icon = Icons.Default.ShoppingCart,
                    text = "Orders"
                )
                RowItem(
                    icon = Icons.Default.List,
                    text = "Offer"
                )
                RowItem(
                    icon = Icons.Default.Phone,
                    text = "Help Center"
                )

            }
        }

        Spacer(modifier =Modifier.size(20.dp))
        Button(onClick = {}, modifier = Modifier.fillMaxWidth().padding(10.dp)) {
            Text("Logout")
        }
    }
}

@Composable
fun RowItem(
    icon: ImageVector, // The icon to be shown in the first column
    text: String, // The text to be displayed in the second column
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(6.dp, top = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Column 1: Icon
        Icon(
            imageVector = icon,
            contentDescription = "Icon",
            tint = Color.Black,
            modifier = Modifier.size(30.dp).background(Color.Green, shape = RoundedCornerShape(20.dp)).padding(6.dp)
        )

        // Column 2: Text
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f).padding(start = 6.dp)
        )

        // Column 3: Right Arrow Icon
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Arrow Right",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
    }
    Spacer(modifier = Modifier.size(12.dp))
    Column(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.Gray)) {  }
}


//@Composable
//fun MainContent(modifier: Modifier) {
//    Row(modifier = Modifier) {
//        Column {
//                Icon(
//                    imageVector = Icons.Default.Person,
//                    contentDescription = "Back",
//                    tint = Color.Black,
//                    modifier = Modifier.size(30.dp).border(1.dp,  color = Color.Black, shape = RoundedCornerShape(30.dp))
//                )
//        }
//    }
//}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun TopBar(navController: NavController) {
//    TopAppBar(
//        title = { Text("Profile") },
//        navigationIcon = {
//            IconButton(
//                onClick = { navController.popBackStack() },
//                modifier = Modifier
//                    .background(Color.White)
////                    .border(1.dp,  color = Color.Black, shape = RoundedCornerShape(30.dp))
////                    .padding(2.dp)
//            ) {
//                Icon(
//                    imageVector = Icons.Default.KeyboardArrowLeft,
//                    contentDescription = "Back",
//                    tint = Color.Black
//                )
//            }
//        },
//        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White),
//        modifier = Modifier
//    )
//}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String, // Customizable title text
//    navController: NavController,
) {
    TopAppBar(
        title = { Text(title) }, // Customizable title
        navigationIcon = {
            IconButton(
                onClick = { },
                modifier = Modifier
                    .background(Color.White)
//                    .border(1.dp,  color = Color.Black, shape = RoundedCornerShape(30.dp))
//                    .padding(2.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White),
        modifier = Modifier
    )
}


@Preview
@Composable
fun ProfileContentPreview(){
    ProfileContent()
}