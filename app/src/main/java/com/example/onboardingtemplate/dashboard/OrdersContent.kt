package com.example.onboardingtemplate.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun OrdersContent(modifier: Modifier = Modifier) {

    Scaffold(
        topBar = { TopBar("Orders") },
        content = { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)){
                Column(modifier = Modifier.padding( horizontal = 16.dp)) {
                    TabNavigation()
                    Spacer(modifier = Modifier.size(6.dp))
                }
            }
        }
    )
}

@Composable
fun TabNavigation() {
    val tabs = listOf("Pending", "History", "Cancelled")
    val selectedTabIndex = remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(
            selectedTabIndex = selectedTabIndex.value,
            modifier = Modifier.fillMaxWidth()
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex.value == index,
                    onClick = {
                        selectedTabIndex.value = index
                    },
                    text = { Text(text = title) }
                )
            }
        }

        // Display content based on selected tab
        Spacer(modifier = Modifier.size(12.dp))
        TabContent(selectedTabIndex.value)
    }
}

@Composable
fun TabContent(tabIndex: Int) {
    when (tabIndex) {
        0 -> PendingTab()
        1 -> HistoryTab()
        2 -> CancelledTab()
    }
}

@Composable
fun PendingTab(){
    LazyColumn {
        items(10) {
            ListColumnItemView(buttonText = "Check") // LazyColumn items below LazyRow
        }
    }
}

@Composable
fun HistoryTab(){
    LazyColumn {
        items(10) {
            ListColumnItemView(buttonText = "Check")// LazyColumn items below LazyRow
        }
    }
}

@Composable
fun CancelledTab(){
    LazyColumn {
        items(10) {
            ListColumnItemView(buttonText = "Check") // LazyColumn items below LazyRow
        }
    }
}
@Preview
@Composable
fun OrdersContentPreview(){
    OrdersContent()
}