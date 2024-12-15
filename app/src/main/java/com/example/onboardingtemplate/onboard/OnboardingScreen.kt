package com.example.onboardingtemplate.onboard

import IndicatorUi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(onFinished:() -> Unit){
    val pages : List<OnboardingModel> = listOf(
        OnboardingModel.FirstPage,
        OnboardingModel.SecondPage,
        OnboardingModel.ThirdPage,
    )
    val pagerState = rememberPagerState(initialPage = 0) {
        pages.size
    }
    val buttonState = remember {
        derivedStateOf {
            when(pagerState.currentPage){
                0 -> listOf("", "Next")
                1 -> listOf("Back", "Next")
                2 -> listOf("Back", "Start")
                else -> listOf("", "")
            }
        }
    }

    val scope = rememberCoroutineScope()

    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(10.dp, 70.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart,

                ) {
                    if(buttonState.value[0].isNotEmpty()){
                        ButtonUi(
                            text = buttonState.value[0],
                            backgroundColor = Color.Transparent,
                            textColor = Color(android.graphics.Color.parseColor("#4CAF50")),
                            borderColor = Color(android.graphics.Color.parseColor("#4CAF50"))
                        ) {
                            scope.launch{
                                if(pagerState.currentPage > 0){
                                    pagerState.animateScrollToPage(pagerState.currentPage - 1)
                                }else{
                                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                                }
                            }
                        }
                    }
                }

                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center
                ){
                    IndicatorUi(
                        pageSize = pages.size,
                        currentPage = pagerState.currentPage
                    )
                }

                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterEnd
                ){
                    ButtonUi(
                        text = buttonState.value[1],
                        backgroundColor = Color(android.graphics.Color.parseColor("#4CAF50")),
                        textColor = Color.White,
                        borderColor = Color(android.graphics.Color.parseColor("#4CAF50"))
                    ){
                        scope.launch{
                            if(pagerState.currentPage < pages.size -1){
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }else{
                                onFinished()
                            }
                        }
                    }
                }
            }
        },
        content = {
            Column(
                Modifier
                    .padding(it)
                    .background(Color.White)
            ) {
                HorizontalPager(state = pagerState) { index ->
                    OnboardingUi(onboardingModel = pages[index])
                }
            }
        }
    )}





@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview(){
    OnboardingScreen(){

    }
}