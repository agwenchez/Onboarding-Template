package com.example.onboardingtemplate.onboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonUi(
    text: String = "Next",
    backgroundColor: Color = MaterialTheme.colorScheme.primaryContainer,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium,
    fontSize: Int = 14,
    borderColor: Color = Color.Black,
    onClick: () -> Unit
) {
    val borderModifier = if (backgroundColor == Color.Transparent) {
        Modifier.border(BorderStroke(1.dp, borderColor), RoundedCornerShape(10.dp))
            .padding(1.dp) // Compensates for the border's height addition
    } else Modifier

    Box(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .height(45.dp)
            .then(borderModifier)
    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                contentColor = textColor,
                containerColor = backgroundColor
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxHeight() // Ensure it takes full size inside the box
        ) {
            Text(
                text = text,
                fontSize = fontSize.sp,
                style = textStyle
            )
        }
    }
}

//@Composable
//fun ButtonUi(
//    text: String = "Next",
//    backgroundColor: Color = MaterialTheme.colorScheme.primaryContainer,
//    textColor: Color = MaterialTheme.colorScheme.onPrimary,
//    textStyle: TextStyle = MaterialTheme.typography.titleMedium,
//    fontSize: Int = 14,
//    borderColor: Color = Color.Black,
//    onClick: () -> Unit
//){
//    Box( modifier = Modifier
//        .height(50.dp)
//        .let {
//            if (backgroundColor == Color.Transparent) {
//                it.border(BorderStroke(1.dp, borderColor), RoundedCornerShape(10.dp))
//            } else it
//        }){
//        Button(
//            onClick = onClick,
//            colors = ButtonDefaults.buttonColors(
//                contentColor = textColor,
//                containerColor = backgroundColor
//            ),
//            shape = RoundedCornerShape(10.dp)
//        ) {
//            Text(
//                text = text,
//                fontSize = fontSize.sp,
//                style = textStyle
//            )
//        }
//    }
//}

@Preview()
@Composable
fun NextButton(){
    ButtonUi {  }
}

@Preview
@Composable
fun BackButton() {
    ButtonUi(
        text = "Back",
        backgroundColor = Color.Transparent,
        textColor = Color.Gray,
        textStyle = MaterialTheme.typography.bodySmall,
        fontSize = 13
    ) {
    }
}