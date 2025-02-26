package com.example.onboardingtemplate.dashboard

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onboardingtemplate.R


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun BrowseContent(modifier: Modifier = Modifier) {
    var searchInput by remember {  mutableStateOf("")}
    Scaffold(
        topBar = { TopBar("Search") },
        content = { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)){
                Column(modifier = Modifier.padding( horizontal = 16.dp)) {
                SearchInputField(
                    label = R.string.search_label,
                    value = searchInput,
                    onValueChange = { searchInput = it},
                    modifier = Modifier
                        .padding(bottom = 24.dp,)
                        .fillMaxWidth(),
                    placeholder = { Text( text = "Search food or chef") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ))

                Spacer(modifier = Modifier.size(6.dp))
                    Text(
                        "History",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        maxItemsInEachRow = 4
                    ){
                        Chip("Fries")
                        Chip("Pizza")
                        Chip("Coffee")
                        Chip("Rice")
                        Chip("Ice Cream")
                        Chip("Fast Food")
                        Chip("Biryani")
                    }
                    Spacer(modifier = Modifier.size(6.dp))
                    Text(
                        "Recommended",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Spacer(modifier = Modifier.size(6.dp))
                    LazyColumn {
                        items(10) {
                            ListColumnItemView() // LazyColumn items below LazyRow
                        }
                    }
                }

            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Chip(text: String,) {
    AssistChip(
        onClick = { Log.d("Assist chip", text) },
        label = { Text(text) },
//        modifier = Modifier.padding(end = 6.dp)
    )
}

@Preview
@Composable
fun BrowseContentPreview(){
    BrowseContent()
}
