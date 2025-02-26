package com.example.onboardingtemplate.dashboard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.onboardingtemplate.chefs.ProductPage
import com.example.onboardingtemplate.ui.screens.ProductsUiState
import com.example.onboardingtemplate.ui.screens.ProductsViewModel


data class BottomNavigationItem(
    val title : String,
    val selectedIcon : ImageVector,
    val unselectedIcon : ImageVector,
    val hasNews : Boolean,
    val badgeCount : Int? = null
)


@Composable
fun Dashboard(
    productsUiState: ProductsUiState,
    retryAction: () -> Unit,
) {
    val items = listOf(
        BottomNavigationItem(
            "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false,
            badgeCount = null
        ),
        BottomNavigationItem(
            "Chefs",
            selectedIcon = Icons.Filled.List,
            unselectedIcon = Icons.Outlined.List,
            hasNews = false,
        ),
        BottomNavigationItem(
            "Browse",
            selectedIcon = Icons.Filled.Search,
            unselectedIcon = Icons.Outlined.Search,
            hasNews = false,
            badgeCount = null
        ),  
        BottomNavigationItem(
            "Orders",
            selectedIcon = Icons.Filled.ShoppingCart,
            unselectedIcon = Icons.Outlined.ShoppingCart,
            hasNews = true,
            badgeCount = 3
        ),  
        BottomNavigationItem(
            "Profile",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
            hasNews = false,
            badgeCount = null
        ),
    )

    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }
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
                val productsViewModel: ProductsViewModel = viewModel(factory = ProductsViewModel.Factory)

                when (selectedItemIndex) {
                    0 -> HomeContent(
//                        productsUiState =  productsViewModel.productsUiState,
//                        retryAction = productsViewModel::getProducts
                    )
                    1 -> ProductPage()
                    2 -> BrowseContent()
                    3 -> OrdersContent()
                    4 -> ProfileContent()
                    else -> Text("Select a tab",)
                }
            }
        }
    }
}

@Preview
@Composable
fun DashboardPreview(){
    val productsViewModel: ProductsViewModel = viewModel(factory = ProductsViewModel.Factory)
    Dashboard(
        productsUiState =  productsViewModel.productsUiState,
        retryAction = productsViewModel::getProducts
    )
}