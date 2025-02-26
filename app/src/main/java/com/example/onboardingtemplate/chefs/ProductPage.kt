package com.example.onboardingtemplate.chefs

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import androidx.navigation.compose.rememberNavController
import com.example.onboardingtemplate.R
import com.example.onboardingtemplate.auth.EditNumberField
import com.example.onboardingtemplate.dashboard.TopBar
import coil.compose.rememberAsyncImagePainter


@Composable
fun ProductPage(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
//        val navController = rememberNavController()
        var nameInput by remember { mutableStateOf("") }
        var descriptionInput by remember { mutableStateOf("") }
        var categoryInput by remember { mutableStateOf("") }
        val categories = listOf("Low Cholesterol", "High Vitamin", "High Fibre", "High Glucose", "Lactose intolerant")

        Scaffold(
            topBar = { TopBar("Add Product") },
        ){ innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal=20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                ImageUploadInput()
                OutlinedTextField(
//                    label = R.string.product_name_label,
                    label = { Text("Product Name") },
//                    leadingIcon = R.drawable.percent,
                    value = nameInput,
                    onValueChange = { nameInput = it},
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                        .fillMaxWidth(),
                    placeholder = { Text("Enter your product name") },
                    keyboardOptions = KeyboardOptions.Default.copy(
//                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
//                    modifier = Modifier.padding(bottom=10.dp)
                )

                CategoryDropdown(
                    categories = categories,
                    selectedCategory = categoryInput,
                    onCategorySelected = { categoryInput = it }
                )
                
                OutlinedTextField(
//                    label = R.string.product_description_label,
//                    leadingIcon = R.drawable.percent,
                    label = { Text("Product Description") },
                    value = descriptionInput,
                    onValueChange = { descriptionInput = it},
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                        .fillMaxWidth()
                        .height(140.dp),
//                    placeholder = { Text("Enter your product name") },
                    keyboardOptions = KeyboardOptions.Default.copy(
//                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
//                    maxLines = 15,
//                    modifier = Modifier.padding(bottom=10.dp)
                )


                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = {},
                    modifier = Modifier
//                        .padding(bottom = 240.dp)
                        .height(50.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .fillMaxWidth(),
//                        .padding(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color(android.graphics.Color.parseColor("#009944"))
                    ),
                    shape = RoundedCornerShape(10.dp),
//                        .background(color = Color(android.graphics.Color.parseColor("#FF6F00")))
                ){
                    Text(
                        text = "Submit",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(android.graphics.Color.parseColor("#FFFFFF"))
                    )
                }
            }
        }
    }
}

@Composable
fun ImageUploadInput() {
    var selectedImageUri by remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        selectedImageUri = uri?.toString()
    }

    Box(
        modifier = Modifier
            .width(150.dp)
            .height(150.dp)
            .background(Color.LightGray.copy(alpha = 0.1f))
            .clip(RoundedCornerShape(2.dp))
            .padding(top=5.dp)
            .border(
                width = 2.dp,
                color = Color.Gray,
            )
            .clickable { launcher.launch("image/*") },
        contentAlignment = Alignment.Center
    ) {
        if (selectedImageUri != null) {
            // Display the selected image
            Image(
                painter = rememberAsyncImagePainter(selectedImageUri),
                contentDescription = "Uploaded Image",
                modifier = Modifier.fillMaxSize()
            )
        } else {
            // Placeholder with a plus icon
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Icon",
                    tint = Color.Gray,
                    modifier = Modifier.size(40.dp)
                )
                Text(
                    text = "Upload Image",
                    color = Color.Gray
                )
            }
        }
    }


}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDropdown(
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        Text(
            text = "Select Category",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = selectedCategory,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth(),
                readOnly = true,
                label = { Text("Category") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },
//                colors = TextFieldDefaults.textFieldColors(
//                    backgroundColor = Color.Transparent
//                )
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                categories.forEach { category ->
                    androidx.compose.material3.DropdownMenuItem(
                        text = { Text(category) },
                        onClick = {
                            onCategorySelected(category)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ProductPageReview(){
    ProductPage()
}